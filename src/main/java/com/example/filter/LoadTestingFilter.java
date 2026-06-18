package com.example.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class LoadTestingFilter extends OncePerRequestFilter {

    @Value("${loadtesting.threshold.total:3}")
    private long totalThreshold;

    @Value("${loadtesting.threshold.concurrent:3}")
    private int concurrentThreshold;

    private final AtomicLong totalRequests = new AtomicLong(0);
    private final AtomicInteger activeRequests = new AtomicInteger(0);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        long currentTotal = totalRequests.incrementAndGet();
        int currentActive = activeRequests.incrementAndGet();

        try {
            if (currentTotal > totalThreshold || currentActive > concurrentThreshold) {
                printRequestDetails(request, currentTotal, currentActive);
            }
            filterChain.doFilter(request, response);
        } finally {
            activeRequests.decrementAndGet();
        }
    }

    private void printRequestDetails(HttpServletRequest request, long total, int active) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n======================================================================\n");
        sb.append("                 [LOAD TESTING THRESHOLD EXCEEDED]\n");
        sb.append("----------------------------------------------------------------------\n");
        
        if (total > totalThreshold && active > concurrentThreshold) {
            sb.append(String.format("Trigger Condition   : Both Total (%d > %d) and Concurrent (%d > %d) thresholds exceeded\n", 
                    total, totalThreshold, active, concurrentThreshold));
        } else if (total > totalThreshold) {
            sb.append(String.format("Trigger Condition   : Total requests processed (%d) exceeded threshold (%d)\n", 
                    total, totalThreshold));
        } else {
            sb.append(String.format("Trigger Condition   : Active concurrent requests (%d) exceeded threshold (%d)\n", 
                    active, concurrentThreshold));
        }
        
        sb.append(String.format("Timestamp           : %s\n", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
        sb.append(String.format("Thread Name         : %s (ID: %d)\n", Thread.currentThread().getName(), Thread.currentThread().getId()));
        sb.append(String.format("Server Port         : %d\n", request.getLocalPort()));
        sb.append(String.format("Server Name         : %s\n", request.getServerName()));
        sb.append(String.format("Client IP           : %s\n", request.getRemoteAddr()));
        sb.append(String.format("HTTP Method         : %s\n", request.getMethod()));
        sb.append(String.format("Request URI         : %s\n", request.getRequestURI()));
        sb.append(String.format("Query String        : %s\n", request.getQueryString() != null ? request.getQueryString() : "None"));
        sb.append("Headers             :\n");

        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                sb.append(String.format("  - %s: %s\n", headerName, request.getHeader(headerName)));
            }
        }
        sb.append("======================================================================\n");
        System.out.println(sb.toString());
    }
}
