package edu.neu.csye6200.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static void writeExcelRowBySheet(String data, String path, int sheetNumber){
      List<String> list = Arrays.asList(data.split(";"));
        try {
            FileInputStream file = new FileInputStream(new File(path));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
            sheet.createRow(sheet.getLastRowNum()+1);
            XSSFRow row = sheet.getRow(sheet.getLastRowNum());

            XSSFCell cell1 = row.createCell(0);
            cell1.setCellValue(list.get(0));

            XSSFCell cell0 = row.createCell(1);
            cell0.setCellType(CellType.NUMERIC);
            cell0.setCellValue(Double.parseDouble(list.get(1)));

            XSSFCell cell2 = row.createCell(2);
            cell2.setCellValue(list.get(2));

            if(list.size()>3){
                XSSFCell cell3 = row.createCell(3);
                cell3.setCellType(CellType.NUMERIC);
                cell3.setCellValue(Double.parseDouble(list.get(3)));
            }

            FileOutputStream fout = new FileOutputStream(path);
            workbook.write(fout);
            file.close();
        } catch (Exception e) {
            logger.error(e);
        }
    }

}

