package com.hustleind.trash;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRegex {
    public static void main(String[] args) {
        //String regex = "^([^;]*);([^;]*);([^;]*);([^;]*);([^;]*);([0-9a-zA-Z\\-]*)$";
        String regex = "^([^;]*);([^;]*);([^;]*);([^;]*);([^;]*);([0-9a-zA-Z\\\\-]*)$";

        String lineToParse = "401015625700631;77778218534;353893081865680;2019-10-22 04:56:08;1;40101-10b2-8a34";

        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile(regex, Pattern.LITERAL)
                .matcher(lineToParse);
        if (m.matches()) {
            for (int i = 1; i <= m.groupCount(); i++) {
                System.out.println(m.group(i));
            }
        }
    }
}
