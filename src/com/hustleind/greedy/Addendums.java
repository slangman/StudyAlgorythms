package com.hustleind.greedy;

import java.util.*;

public class Addendums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long num = input.nextLong();
        count(num);
    }

    public static void count(long num) {
        Set<Long> resultSet = new HashSet<>();
        long result = 0;
        long counter = 0;

        if (num<=2) {
            resultSet.add(num);
        } else {
            long excessFirst = 3;
            long add = 1;
            while (result<=num) {
                long excess = excessFirst;
                while(excess>0) {
                    add++;

                    excess--;
                }
                excessFirst++;
            }
        }


        System.out.println(resultSet.size());
        resultSet.forEach(System.out::print);
    }
}
