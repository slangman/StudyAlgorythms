package com.hustleind.greedy;

import java.util.*;

/**
 * Задание
 *
 * По данному числу 1≤n≤10 найдите максимальное число k, для которого n можно представить как сумму k различных натуральных слагаемых.
 * Выведите в первой строке число k, во второй — k слагаемых.
 *
 * Есть подозрение, что решение очень плохое, но валидатор принял.
 */
public class Addendums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long num = input.nextLong();
        count(num);
    }

    public static void count(long num) {
        if (num<3) {
            System.out.println(1);
            System.out.println(num);
            return;
        }
        Set<Long> resultSet = new HashSet<>();
        long sum = 0;
        long add = 1;
        while (sum < num) {
            sum += add;
            resultSet.add(add);
            add++;
        }

        long exclude = 0;
        long a = 2;
        long exclude1 = 2;
        for (long i = 1; i <= num; i++) {
            if (i > 3) {
                exclude = exclude1;
                if (exclude1==0) {
                    exclude1 = ++a;
                } else {
                    exclude1--;
                }
            }
        }
        resultSet.remove(exclude);

        System.out.println(resultSet.size());
        resultSet.forEach(e-> System.out.print(e + " "));
    }
}
