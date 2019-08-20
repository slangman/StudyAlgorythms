package com.hustleind;

import java.util.Scanner;

public class FibonacciFirst {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        int a = myInput.nextInt();
        System.out.println(count(a));
    }

    public static long count(int n) {
        long[] resultArray = new long[n+1];
        resultArray[0] = 0;
        resultArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            resultArray[i] = resultArray[i - 1] + resultArray[i - 2];
        }
        return resultArray[n];
    }
}
