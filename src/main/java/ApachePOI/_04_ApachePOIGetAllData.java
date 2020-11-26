package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {
        String path="src/main/resources/ApacheExcel1.xlsx";
        FileInputStream inputStream= new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet= workbook.getSheet("Sheet1");

        // calisma sayfasındaki toplam satır sayısını veriyor.
        int rowCount= sheet.getPhysicalNumberOfRows();
        System.out.println("Satir Sayırıs="+rowCount);

        for(int i=0;i<rowCount ;i++) // satır sayısı kadar dönecek
        {
            Row row=sheet.getRow(i); // i.Satır alındı
            int cellCount = row.getPhysicalNumberOfCells(); // bu satırdaki toplam hücre sayısı alındı.

            for(int j=0;j< cellCount;j++ ) // i.satırdaki hucre sayısı kadar dönecek
            {
                Cell cell = row.getCell(j); // bu satırdaki sıradaki hücreyi aldım.
                System.out.print(cell+" ");
            }
            System.out.println();
        }
    }
}
