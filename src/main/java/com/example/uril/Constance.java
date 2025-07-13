package com.example.uril;

public class Constance {
    

    public static void println(String value) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RED = "\u001B[31m";

        System.out.println(ANSI_GREEN + value + ANSI_RESET);
    }
}
