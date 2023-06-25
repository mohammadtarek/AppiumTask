package reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader {


    private static final int SHEET_INDEX = 0; // Index of the sheet containing the data

    public static String[][] readDataFromExcel() throws IOException {

            FileInputStream fis = new FileInputStream("E:\\ITI intake-43\\ITI\\MobileDemo\\src\\test\\java\\reader\\Testdata.xlsx");
            XSSFWorkbook workbook =new XSSFWorkbook(fis);
            XSSFSheet sheet= workbook.getSheetAt(0); //to get the first sheet
        Iterator<Row> rows=sheet.iterator();

        int totalNumberOfRows = sheet.getLastRowNum() +1;
        int totalNumberOfCols = 7;
        String[][] arrayOfExelData = new String[totalNumberOfRows][totalNumberOfCols];
        for (int i = 0; i < totalNumberOfRows; i++) {
            for (int j = 0; j < totalNumberOfCols; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayOfExelData[i][j] = row.getCell(j).toString();
            }

        }

        workbook.close();
        return arrayOfExelData;

        }




}
