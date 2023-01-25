package com.sd.utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelTestDataReader {
    public XSSFWorkbook wb;

    public ExcelTestDataReader (){
        File src = new File("./TestData/TestData.xlsx");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println("Error while accessing file: " +e.getMessage());;
        }
    }

    public String getStringData(String sheetName, int rowNum, int columnNum){
        return wb.getSheet(sheetName).getRow(rowNum).getCell(columnNum).getStringCellValue();
    }

    public int getNumericData(String sheetName, int rowNum, int columnNum){
        return (int) wb.getSheet(sheetName).getRow(rowNum).getCell(columnNum).getNumericCellValue();
    }

    public String getStringData(int sheetIndex, int rowNum, int columnNum){
        return wb.getSheetAt(sheetIndex).getRow(rowNum).getCell(columnNum).getStringCellValue();
    }
}
