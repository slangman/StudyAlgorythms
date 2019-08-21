package com.hustleind.fibonacci;

import java.util.Scanner;

public class FibonacciLastDigit {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        int a = myInput.nextInt();
        System.out.println(count(a));
    }

    public static int count(int n) {
        int first = 0;
        int second = 1;
        int third = 1;
        for (int i = 2; i <= n; i++) {
            third = (first + second) % 10;
            first = second;
            second = third;
        }
        return third;
    }
}
