package com.hustleind.priorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTask {
    static PriorityQueue<Integer> priorityQueue;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int actionsCounter = 0;
        if (input.hasNextLine()) {
            actionsCounter = Integer.parseInt(input.nextLine());
        }
        priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        List<String> actions = new ArrayList<>();
        for (int i = 0; i < actionsCounter; i++) {
            String action = input.nextLine();
            if (action.isEmpty()) {
                break;
            }
            actions.add(action);
        }
        process(actions);
    }

    private static void process(List<String> actions) {
        actions.forEach(action -> {
            if (action.equals("ExtractMax")) {
                System.out.println(priorityQueue.poll());
            } else if (action.contains("Insert ")) {
                priorityQueue.add(Integer.parseInt(action.split(" ")[1]));
            }
        });
    }

}
