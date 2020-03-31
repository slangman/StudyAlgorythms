package com.hustleind.divideAndConquire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Задание:
 * Первая строка содерижт число 1 <= n <= 10^5, вторая - массив A[1...n], содержащий натуральные числа,
 * не превосходящие 10^9. Необходимо посчитать число пар индексов 1 <= i < j <= n, для которых A[i] > A[j].
 *  (Такая пара элементов называется инверсией массива. Количество инверсий в массиве является
 *  в некотором смысле его мерой неупорядоченности: например, в упорядоченном по неубыванию массиве
 *  инверсий нет вообще, а в массиве, упорядоченном по убыванию, инверсию образуют каждые два элемента.)
 *
 *  Формат входных данных:
 *  5
 *  2 3 9 2 9
 *
 *  Формат выходных данных:
 *  2
 */

public class Inversions {

    static long count = 0;

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner тормозной, лучше использовать BufferedReader или Files.lines
        Scanner input = new Scanner(new File("c://test/generator.txt"));
        int n = input.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextLong();
        }

        long start = System.currentTimeMillis();
        long[] sortedA = mergeSort(a);
        long finish = System.currentTimeMillis();
        System.out.println(count);

        System.out.println("count time " + (finish - start) + " ms");
        //Для ручного ввода
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String nums = "";
        while (nums.equals("")) {
            nums = scanner.nextLine();
        }
        String[] numsSplitted = nums.split(" ");
        long[] array = new long[numsSplitted.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Long.parseLong(numsSplitted[i]);
        }
        */
        //System.out.println(Arrays.toString(merge(new long[]{2, 5, 6, 14, 25}, new long[]{1, 3, 4, 5, 7, 8})));
    }

    static int count(long[] array) {
        return 0;
    }

    static long[] merge(long[] a, long[] b) {
        int i = 0;
        int j = 0;
        long[] res = new long[a.length + b.length];
        for (int k = 0; k < res.length; k++) {
            if (j == b.length || (i < a.length && a[i] <= b[j])) {
                res[k] = a[i];
                i++;
            } else {
                //a[i, i+i, ... , a.length - 1] > b[j];
                count += a.length - i;
                res[k] = b[j];
                j++;

            }
        }
        return res;
    }

    static long[] mergeSort(long[] a) {
        if (a.length == 1) {
            return a;
        }
        //сперва разбиваем массив пополам
        int n = a.length;
        int m = n / 2;
        long[] left = new long[m];
        long[] right = new long[n - m];
        System.arraycopy(a, 0, left, 0, m);
        System.arraycopy(a, m, right, 0, n - m);
        //потом для каждого массива запускаем рекурсивно
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
}
