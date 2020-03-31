package com.hustleind.divideAndConquire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


//Алгоритм сортировки слиянием и сравнение со скоростью работы встроенного алкгоритма сортировки массивов
public class MergeSort {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader("c://test/generator.txt"));
        String inputLine = reader.readLine();
        String[] tokens = inputLine.split(" ");
        long[] array = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = Long.parseLong(tokens[i]);
        }

        long startArraysSort = System.currentTimeMillis();
        Arrays.sort(array);
        long finishArraysSort = System.currentTimeMillis();
        System.out.println("System Arrays.sort time: " + (finishArraysSort-startArraysSort) + " ms");

        long startMergeSort = System.currentTimeMillis();
        mergeSort(array);
        long finishMergeSort = System.currentTimeMillis();
        System.out.println("Merge sort time: " + (finishMergeSort-startMergeSort) + " ms");

    }

    static long[] mergeSort(long[] a) {
        if (a.length == 1) {
            return a;
        }
        int n = a.length;
        int m = n / 2;
        long[] left = new long[m];
        long[] right = new long[n - m];
        System.arraycopy(a, 0, left, 0, m);
        System.arraycopy(a, m, right, 0, n - m);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    static long[] merge(long[] a, long[] b) {
        int i = 0;
        int j = 0;
        long[] res = new long[a.length + b.length];
        for (int k = 0; k < res.length; k++) {
            if (j == b.length || (i < a.length && a[i] < b[j])) {
                res[k] = a[i];
                i++;
            } else {
                res[k] = b[j];
                j++;
            }
        }
        return res;
    }
}
