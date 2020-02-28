package com.hustleind.trash;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TempClass {
    public static void main(String[] args) {
        String dirPath = "/dmc/computing/temporary/stg_subs_trans_daily/1E4E8E0F-A427-4B75-AA80-F832D282DCB1/";
        String dirPathNew = "";
        if (dirPath.endsWith("/")) {
            dirPath = dirPath.substring(0, dirPath.length() - 1);
        }
        String dirName = dirPath.substring(dirPath.lastIndexOf("/") + 1);
        String dirName1 = "_" + dirName;
        dirPathNew = dirPath.substring(0, dirPath.lastIndexOf("/") + 1) + dirName1;

        System.out.println(dirPathNew);
    }
}
