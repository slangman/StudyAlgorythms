package com.hustleind.huffman;

import java.util.*;
import java.util.stream.Collectors;

public class EncodeHuffman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        encode(inputString);
    }

    static void encode(String input) {
        printSymbolsNum(input);
        char[] characters = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Queue<Object> queue = new ArrayDeque<>();
        for (char character : characters) {
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
        Map<Character, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        sortedMap.forEach((k, v) -> {
            queue.add(k);
        });


        queue.forEach(e -> {
            char letterForLeft = (Character) queue.poll();
            char letterForRight = (Character) queue.poll();
            Node left = new Node(letterForLeft, sortedMap.get(letterForLeft));
            Node right = new Node(letterForRight, sortedMap.get(letterForRight));
            Node node = new Node('@', sortedMap.get(letterForLeft) + sortedMap.get(letterForRight), left, right);
            queue.add(node);
        });


    }

    static void printSymbolsNum(String s) {
        System.out.println(s.chars().distinct().count());
    }


}
