package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadTestController {

    @GetMapping("/api/test/sleep")
    public String testSleep(@RequestParam(defaultValue = "5000") long ms) {
        String threadName = Thread.currentThread().getName();
        System.out.println(">>> Request on thread [" + threadName + "] starting sleep of " + ms + " ms");
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Sleep interrupted on thread " + threadName;
        }
        System.out.println("<<< Request on thread [" + threadName + "] finished sleep");
        return "Done sleeping for " + ms + " ms on thread " + threadName + "\n";
    }
}
