package com.hustleind.greedy;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Задание:
 * <p>
 * Первая строка содержит количество предметов 1 ≤ n ≤ 1 000 и вместимость рюкзака 0 ≤ W ≤ 2000000.
 * <p>
 * Каждая из следующих n строк задаёт стоимость 0 ≤ ci ≤ 2 000 000 и объём 0 < wi ≤ 2 000 000 предмета
 * (n, W, ci, wi — целые числа).
 * <p>
 * Выведите максимальную стоимость частей предметов (от каждого предмета можно отделить любую часть,
 * стоимость и объём при этом пропорционально уменьшатся), помещающихся в данный рюкзак,
 * с точностью не менее трёх знаков после запятой.
 */

public class KnapsackProblem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int items = 0;
        double backpackVolume = 0D;
        List<double[]> itemsValues = new ArrayList<>();
        if (input.hasNextLine()) {
            String line = input.nextLine();
            items = Integer.parseInt(line.split(" ")[0]);
            backpackVolume = Double.parseDouble(line.split(" ")[1]);
        }
        for (int i = 0; i < items; i++) {
            String nextLine = input.nextLine();
            if (nextLine.isEmpty()) {
                break;
            }
            double itemValue = Double.parseDouble(nextLine.split(" ")[0]);
            double itemVolume = Double.parseDouble(nextLine.split(" ")[1]);
            itemsValues.add(new double[]{itemValue, itemVolume});
        }
        count(backpackVolume, itemsValues);
    }

    public static void count(double backpackVolume, List<double[]> itemsValues) {
        double resultValue = 0D;
        //сортируем предметы в порядке уменьшения стоимости за единицу объема.
        itemsValues.sort(Comparator.comparingDouble(a -> (a[0] / a[1])));
        Collections.reverse(itemsValues);
        /**
         * Проходим по списку предметов. Если предмет помещается в оставшееся место в рюкзаке целиком, кладем его целиком,
         * добавляем к суммарной стоимости стоимость предмета.
         * Если предмет целиком не помещается, находим какую часть предмета можно поместить,
         * кладем её, добавляем пропорциональную часть часть его стоимости к суммарной стоимости.
         */
        for (double[] item : itemsValues) {
            if (backpackVolume == 0) {
                break;
            }
            if (item[1] <= backpackVolume) {
                resultValue += item[0];
                backpackVolume -= item[1];
            } else {
                double divider = item[1] / backpackVolume;
                resultValue += item[0] / divider;
                backpackVolume = 0;
            }
        }
        DecimalFormat df = new DecimalFormat("#.000");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(df.format(new Double(resultValue)));
    }

}
