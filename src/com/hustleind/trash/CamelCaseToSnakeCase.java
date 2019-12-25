package com.hustleind.trash;

import com.google.common.base.CaseFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CamelCaseToSnakeCase {
    public static void main(String[] args) {
        String[] input = new String[] {
                "NewBalance1",
                "NewBalance2",
                "NewBalance3",
                "NewBalance4",
                "NewBalance5",
                "NewBalance6",
                "NewBalance7",
                "NewBalance8",
                "NewBalance9",
                "NewBalance10",
                "NewBalance11",
                "NewBalance12",
                "NewBalance13",
                "NewBalance14",
                "NewBalance15",
                "NewBalance16",
                "NewBalance17",
                "NewBalance18",
                "NewBalance19",
                "NewBalance20",
                "NewBalance21",
                "NewBalance22",
                "NewBalance23",
                "NewBalance24",
                "NewBalance25",
                "NewBalance26",
                "NewBalance27",
                "NewBalance28",
                "NewBalance29",
                "NewBalance30",
                "ChangeAmount1",
                "ChangeAmount2",
                "ChangeAmount3",
                "ChangeAmount4",
                "ChangeAmount5",
                "ChangeAmount6",
                "ChangeAmount7",
                "ChangeAmount8",
                "ChangeAmount9",
                "ChangeAmount10",
                "ChangeAmount11",
                "ChangeAmount12",
                "ChangeAmount13",
                "ChangeAmount14",
                "ChangeAmount15",
                "ChangeAmount16",
                "ChangeAmount17",
                "ChangeAmount18",
                "ChangeAmount19",
                "ChangeAmount20",
                "ChangeAmount21",
                "ChangeAmount22",
                "ChangeAmount23",
                "ChangeAmount24",
                "ChangeAmount25",
                "ChangeAmount26",
                "ChangeAmount27",
                "ChangeAmount28",
                "ChangeAmount29",
                "ChangeAmount30",

        };

        StringBuilder sb = new StringBuilder("");
        for (String s : input) {
            String converted = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, s);
            sb.append("\"" + converted + "\", ");
        }
        if (sb.length()!=0) {
            System.out.println( (sb.subSequence(0, sb.length() - 2)).toString());
        }
    }
}
