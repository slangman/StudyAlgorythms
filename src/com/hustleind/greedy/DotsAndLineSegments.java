package com.hustleind.greedy;

import java.util.*;

/**
 * Задание:
 * Даны отрезки на прямой. Найти такие точки, которые лежат на всех заданных отрезках. Найденное множество должно быть минимальным по размеру.
 *
 * Формат входных данных:
 * Первая строка - количество отрезков
 * Последующие строки - координаты начала и конца отрезка, разделенные пробелом
 *
 * Формат выходных данных:
 * Первая строка - количество найденных точек
 * Вторая строка - найденные точки, разделенные пробелом
 */

public class DotsAndLineSegments {

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        List<Integer> arguments = new ArrayList<>();
        int lines = 0;
        if (myInput.hasNextLine()) {
            lines = Integer.parseInt(myInput.nextLine());
        }

        for (int i = 0; i < lines; i++) {
            String nextLine = myInput.nextLine();
            if (nextLine.isEmpty()) {
                break;
            }
            arguments.add(Integer.parseInt(nextLine.split(" ")[0]));
            arguments.add(Integer.parseInt(nextLine.split(" ")[1]));
        }

        count(arguments);
    }

    public static void count(List<Integer> arguments) {
        int dotsCount = 0;
        List<Integer> dots = new ArrayList<>();
        List<int[]> segments = new ArrayList<>();
        for (int i = 0; i < arguments.size() - 1; i += 2) {
            segments.add(new int[]{arguments.get(i), arguments.get(i + 1)});
        }
        //Сортируем отрезки по правым концам
        segments.sort(Comparator.comparingInt(a -> (a[1])));

        //Создаем копию отсортированного списка отрезков
        List<int[]> checkedSegments = new ArrayList<>();
        segments.forEach(segment -> {
            checkedSegments.add(segment);
        });

        /**
         * Проходим по всем точкам - правым концам отрезков.
         * Если точка входит в отрезок из списка checkedSegments, удаляем этот отрезок из списка.
         */
        for (int[] segment : segments) {
            if (checkedSegments.contains(segment)) {
                dots.add(segment[1]);
                dotsCount++;
                for (int[] segment1 : segments) {
                    if (segment1[0] <= segment[1] && segment[1] <= segment1[1]) {
                        checkedSegments.remove(segment1);
                    }
                }
            }
        }

        System.out.println(dotsCount);
        dots.forEach(dot -> {
            System.out.print(dot + " ");
        });
    }
}
