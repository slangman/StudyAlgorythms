package com.hustleind.divideAndConquire;

import java.util.Scanner;

public class Multiply {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println(multiply(a,b));
    }

    public static int multiply(int a, int b) {
        if (b==0) {
            return 0;
        }
        int c = multiply(a, (int)Math.floor(b/2));
        if (b%2==0) {
            return 2*c;
        } else {
            return a+2*c;
        }
    }
}
