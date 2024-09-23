package util;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class ExelFile {
    public static FileInputStream fi;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static String link = "C:\\BridgeLabz\\Quality Kiosk\\Automation_Testing\\GivaTest_Automation\\src\\main\\java\\com\\giva\\qa\\testdata\\Giva_TestData.xlsx";

    public  static String[][] getData(String Sheets) throws IOException {
        int totalRows = getRowCount(Sheets);
        int totalCols = getColCount(Sheets,1);

        String loginData[][] = new String[totalRows][totalCols];
        for(int i=1;i<=totalRows;i++){
            for(int j=0;j<totalCols;j++){
                loginData[i-1][j]= getCellData(Sheets,i,j);
            }
        }
        return loginData;
    }
    public static int getRowCount(String sheetName) throws IOException {
        fi = new FileInputStream(link);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    public static int getColCount(String sheetName, int rownum) throws IOException {
        fi = new FileInputStream(link);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }


    public static String getCellData(String sheetName, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(link );
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        cell = row.getCell(colnum);

        String data;
        try{
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
        }
        catch (Exception e){
            data = " ";
        }
        wb.close();
        fi.close();
        return data;
    }

    @DataProvider(name = "LoginData")
    public static Object[][] loginData() throws IOException {
        return getData("Sheet1");
    }

    @DataProvider(name = "signUpData")
    public static Object[][] signUpData() throws IOException {
        return getData("Sheet2");
    }

    @DataProvider(name = "SearchData")
    public static Object[][] searchData() throws IOException {
        return getData("Sheet3");
    }


}