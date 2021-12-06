package edu.neu.csye6200.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> readByLines(String path) {
        List<String> content = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));){
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                content.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void readExcel(){

    }
}

