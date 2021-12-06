package edu.neu.csye6200.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    private static final Logger logger = LogManager.getLogger(FileUtil.class);

    public static List<String> readTextByLines(String path) {
        List<String> content = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));) {
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                content.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static List<Row> readExcelRowBySheet(String path, int sheetNumber) {
        List<Row> rowList = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(new File(path));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
            for (Row row : sheet) {
                rowList.add(row);
            }
            file.close();
        } catch (Exception e) {
            logger.error(e);
        }
        return rowList;
    }

}

