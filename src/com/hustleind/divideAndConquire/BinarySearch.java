package com.hustleind.divideAndConquire;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Задание:
 * В первой строке даны целое число n и упорядоченный массив натуральных чисел > 0 размера n.
 * Во второй строке - целое число k и массив натуральных чисел размером k.
 * Для каждого числа во втором массиве найти индекс числа равного ему из первого массива.
 */

public class BinarySearch {
    private static int[] firstLineNumbers;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstLine = input.nextLine();
        String secondLine = input.nextLine();
        String[] firstLineSplitted = firstLine.split(" ");
        String[] secondLineSplitted = secondLine.split(" ");
        firstLineNumbers = new int[firstLineSplitted.length];
        for (int i = 0; i < firstLineSplitted.length; i++) {
            firstLineNumbers[i] = Integer.parseInt(firstLineSplitted[i]);
        }
        List<Integer> secondLineNumbers = new ArrayList<>();
        for (int i = 1; i < secondLineSplitted.length; i++) {
            secondLineNumbers.add(Integer.parseInt(secondLineSplitted[i]));
        }
        List<Integer> result = new ArrayList<>();
        secondLineNumbers.forEach(e-> {
            result.add(search(1, firstLineNumbers.length-1, e));
        });
        result.forEach(e-> {
            System.out.print(e + " ");
        });
    }

    private static int search(int start, int end, int num) {
        if ((end-start)<2) {
            if (firstLineNumbers[start] == num) {
                return start;
            } else if (firstLineNumbers[end] == num) {
                return end;
            } else {
                return -1;
            }
        }
        int middlePosition = (end+start)/2;
        int middle = firstLineNumbers[middlePosition];
        if (num<middle) {
             return search(1, middlePosition, num);
        } else if (num>middle) {
            return search(middlePosition+1, end, num);
        } else {
            return middlePosition;
        }
    }
}
