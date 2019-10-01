package com.hustleind.fibonacci;

import java.util.Scanner;

/**
 * Алгоритм нахождения числа Фибоначчи
 */

public class FibonacciFirst {
    public static void main(String[] args) {
        //для ручного ввода
        /*Scanner myInput = new Scanner(System.in);
        int a = myInput.nextInt();
        System.out.println(count(a));*/
        for (int a=1; a < 1000; a++) {
            long startTime = System.currentTimeMillis();
            System.out.println(count(a));
            long endTime = System.currentTimeMillis();
            System.out.println(endTime-startTime + " ms");
            //время выполнения практически не меняется
        }
    }

    public static long count(int n) {
        long[] resultArray = new long[n + 1];
        resultArray[0] = 0;
        resultArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            resultArray[i] = resultArray[i - 1] + resultArray[i - 2];
        }
        return resultArray[n];
    }
}
