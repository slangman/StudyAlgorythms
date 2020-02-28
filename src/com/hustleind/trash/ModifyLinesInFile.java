package com.hustleind.trash;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ModifyLinesInFile {
    public static void main(String[] args) {
        String inputFile = args[0];
        String outputFile = args[1];

        try (Stream<String> stream = Files.lines(Paths.get(inputFile));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))) {
            stream.forEach(line -> {
                line = line.split(" ")[0];
                line = line.substring("hdfs://kz-dmphdpname03:8020".length());
                try {
                    writer.write(line);
                    writer.write(System.lineSeparator());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
