package com.hustleind.trash;

/**
 * Ищет в переданном массиве строки, начинающиеся с "null" и возвращает индексы элементов
 */

public class GetIndexOfNullElement {
    public static void main(String[] args) {
        String[] OSA = new String[]{"SERVICE_VERSION_ID", "SUB_TYPE_ID", "DISPLAY_VALUE", "INSTANCE_FLAG", "Null", "SUB_TYPE_CODE"};

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < OSA.length; i++) {
            if (OSA[i].length() >= 4  && OSA[i].substring(0,4).equalsIgnoreCase("null")) {
                sb.append(i).append(", ");
            }
        }
        if (sb.length()!=0) {
            System.out.println(sb.subSequence(0, sb.length() - 2).toString());
        }
    }
}
