package com.hustleind.divideAndConquire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DotsAndLineSegments2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = reader.readLine();
        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int m = Integer.parseInt(firstLine.split(" ")[1]);
        List<long[]> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String nextLine = reader.readLine();
            long a = Long.parseLong(nextLine.split(" ")[0]);
            long b = Long.parseLong(nextLine.split(" ")[1]);
            segments.add(new long[]{a, b});
        }
        String lastLine = reader.readLine();
        String[] lastLineSplitted = lastLine.split(" ");
        long[] dots = new long[m];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = Long.parseLong(lastLineSplitted[i]);
        }
    }

    static int[] count(List<long[]> segments, long[] dots) {
        return new int[0];
    }
}
