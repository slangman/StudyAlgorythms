package com.hustleind.divideAndConquire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//Алгоритм быстрой сортировки и сравнение со скоростью работы встроенного алкгоритма сортировки массивов
public class QuickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("c://test/generator.txt"));
        String inputLine = reader.readLine();
        String[] tokens = inputLine.split(" ");
        long[] array = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = Long.parseLong(tokens[i]);
        }

        long start = System.currentTimeMillis();
        Arrays.sort(array);
        long finish = System.currentTimeMillis();
        System.out.println("System Arrays.sort time: " + (finish - start) + " ms");

        /*long start = System.currentTimeMillis();
        quickSort(array, 0, array.length);
        long finish = System.currentTimeMillis();
        System.out.println("Quick.sort time: " + (finish - start) + " ms");*/
    }

    static void quickSort(long[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = partition(a, l, r);
        quickSort(a, l, m - 1);
        quickSort(a, m + 1, r);
    }

    static int partition(long[] a, int l, int r) {
        long x = a[l];
        int j = l;
        for (int i = l + 1; i < r; i++) {
            if (a[i] <= x) {
                j = j + 1;
                long temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        long temp = a[j];
        a[j] = a[l];
        a[l] = temp;
        return j;
    }

}
