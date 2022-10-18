package settings;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by: Al Imran on 21/09/2018.
 * Email: imranreee@gmail.com
 **/

public class ExcelRead {

    //This method perform Excel Read action
    public static String readData(String excelPath, int sheetNum, int rowNum, int columnNum) throws IOException {
        File src = new File(excelPath);
        FileInputStream fis = new FileInputStream(src);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh1 = wb.getSheetAt(sheetNum);

        String data = sh1.getRow(rowNum).getCell(columnNum).getStringCellValue();
        return data;
    }
}