package Utilities;

import cucumber.api.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {

    public static List<List<String>> getListData(String path, String sheetName, int columnCount)
    {
        List<List<String>> donecekList=new ArrayList<>();

        Workbook workbook=null;
        try {
            FileInputStream inputStream=new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet=workbook.getSheet(sheetName);
        int rowCount=sheet.getPhysicalNumberOfRows();

        for(int i=0;i<rowCount;i++)
        {
            List<String> rowList=new ArrayList<>();
            Row row=sheet.getRow(i);

            int cellCount= row.getPhysicalNumberOfCells();
            if (columnCount > cellCount) columnCount=cellCount;

            for(int j=0;j<columnCount;j++)
            {
                rowList.add(row.getCell(j).toString());
            }

            donecekList.add(rowList);
        }

        return donecekList;
    }

    //ExcelUtility.exceleYaz(scenario, strDate,Driver.threadBrowserName.get());

    public static void exceleYaz(Scenario scenario, String time, String Browser){

        String paht="src/main/resources/ScenarioResults.xlsx";

        File f=new File(paht);

        XSSFSheet sheet=null;
        if (!f.exists()){

        XSSFWorkbook workbook=new XSSFWorkbook(); // hazfızada workbook oluştur.
        sheet=workbook.createSheet("Sonuclar"); // hazıfazda sheet oluştur.

            int numberOfRows= sheet.getPhysicalNumberOfRows()+1;

            Row row=sheet.createRow(numberOfRows); // satır oluştur

            Cell cell=row.createCell(0); // hucre oluştur
            cell.setCellValue(scenario.getId());

            cell=row.createCell(1); // hucre oluştur
            cell.setCellValue(scenario.getStatus());

            cell=row.createCell(2); // hucre oluştur
            cell.setCellValue(time);

            cell=row.createCell(3); // hucre oluştur
            cell.setCellValue(Browser);

            cell.setCellValue("Merhaba Dünya biz geldik."); // hucreye hafızada yaz.

            FileInputStream outputStream=null;
            try {
                outputStream = new FileInputStream(paht);
               // workbook.write(outputStream); // içine hafızadaki bilgileri yazdık.
                workbook.close(); // hafızayı boşalttık
                outputStream.close(); // dosyayı kapattık.
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }

        }





        //public static void main(String[] args) {
        List<List<String>> gelenList= getListData("src/main/resources/ApacheExcel1.xlsx","testCitizen",2);
        System.out.println(gelenList);

        gelenList= getListData("src/main/resources/ApacheExcel1.xlsx","testCitizen",4);
        System.out.println(gelenList);

        gelenList= getListData("src/main/resources/ApacheExcel1.xlsx","testCitizen",10);
        System.out.println(gelenList);
    }
}