package core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFile {
    public static final String EXCELFILE_LOCATION = "C:\\Users\\Yash_Choube\\Documents\\FormTestdata2.xlsx";

    private static FileInputStream fis;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;

    public static void loadExcel(String sheetName) throws Exception {
        File file = new File(EXCELFILE_LOCATION);
        fis = new FileInputStream(file);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        fis.close();
    }

    //@org.jetbrains.annotations.NotNull
    public static List<Map<String, String>> readTestData(String sheetName) throws Exception {

       // if (sheet == null) {
            loadExcel(sheetName);
       // }

        List <Map<String, String>> mapList = new ArrayList<>();

        row = sheet.getRow(0);
        int col = row.getLastCellNum();

        for(int i = 1;i <sheet.getLastRowNum()+1;i++){
            Map<String,String> dataMap = new HashMap<>();
            DataFormatter formatter = new DataFormatter();
            for(int j=0;j<col ;j++){


                Row r = CellUtil.getRow(0,sheet);
                Row s= CellUtil.getRow(i,sheet);
                String key = CellUtil.getCell(r,j).getStringCellValue();
                String value = formatter.formatCellValue(CellUtil.getCell(s,j));
                dataMap.put(key, value);
            }
            mapList.add(dataMap);

         }
        return mapList;
    }

    public static Map<String, String> displayData(String sheetName,String row) throws Exception {
        //readTestData(sheetName);
        System.out.println(readTestData(sheetName));
       List<Map<String, String>> display = readTestData(sheetName);
       int rowNumber = Integer.parseInt(row);
        return (display.get(rowNumber));
////        for (Map<String, String> data:display.get(1)) {
////            System.out.println(data);
////        }
   }

//    public static void displayData() throws  Exception{
//        System.out.println(readTestData());
//    }

}
