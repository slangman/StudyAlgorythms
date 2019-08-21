package com.hustleind.gcd;

import java.util.Scanner;

/**
 * Алгоритм Евклида для нахождения наибольшего общего делителя
 */

public class EuclidGCD {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        int a = myInput.nextInt();
        int b = myInput.nextInt();
        System.out.println(count(a, b));
    }

    /*public static int count(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a >= b) {
            return count(a % b, b);
        } else {
            return count(a, b % a);
        }
    }*/

    public static int count(int a, int b) {
        return (a == 0 ? b
                : b == 0 ? a
                : a >= b ? count(a % b, b)
                : count(a, b % a));
    }
}
