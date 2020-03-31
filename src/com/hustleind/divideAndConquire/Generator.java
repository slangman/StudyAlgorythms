package com.hustleind.divideAndConquire;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Generator {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("c://test/generator.txt");
        int n= 1000000;
        Random random = new Random();
        //printWriter.println(n);
        for (int i = 0; i < n; i++) {
            printWriter.print(random.nextLong() + " ");
        }
        printWriter.close();
    }
}
