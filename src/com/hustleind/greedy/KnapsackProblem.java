package com.hustleind.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnapsackProblem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int items = 0;
        int backpackVolume = 0;
        List<int[]> itemsValues = new ArrayList<>();
        if (input.hasNextLine()) {
            String line = input.nextLine();
            items = Integer.parseInt(line.split(" ")[0]);
            backpackVolume = Integer.parseInt(line.split(" ")[1]);
        }
        for (int i = 0; i < items; i++) {
            String nextLine = input.nextLine();
            if (nextLine.isEmpty()) {
                break;
            }
            int itemValue = Integer.parseInt(nextLine.split(" ")[0]);
            int itemVolume = Integer.parseInt(nextLine.split(" ")[1]);
            itemsValues.add(new int[]{itemValue, itemVolume});
        }

        count(backpackVolume, itemsValues);
    }

    public static void count(int backpackVolume, List<int[]> itemsValues) {
        System.out.println(backpackVolume);
        itemsValues.forEach(array-> {
            System.out.println(array[0] + " " + array[1]);
        });
    }

}
