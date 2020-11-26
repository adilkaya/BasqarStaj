package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GetASpecicifData_Kendim {
    public static void main(String[] args) throws IOException {

        String path="src/main/resources/LoginData.xlsx";

        //dosyayı yani Exceli okumaya açtım.
        FileInputStream inputStream = new FileInputStream(path);

        //Bunun üzerinden Çalışma Kitabını alıyorum
        Workbook workbook= WorkbookFactory.create(inputStream);

        //istediğim isimdeki çalışma sayfasını alıyorum
        Sheet sheet= workbook.getSheet("Login");
        //Sheet calismaSayfasiAyni= calismaKitabi.getSheetAt(0);

        Row row;  //istenen Satırı alıyorum
        Cell cell; //istenen satırdaki istenen hücre aliniyor.

        int rowCount= sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowCount; i++) {

            row=sheet.getRow(i); //istenen Satırı alıyorum
            cell=row.getCell(0); //istenen satırdaki istenen hücre aliniyor.

            if (cell.toString().equalsIgnoreCase("Password"))
            {
                cell=row.getCell(1);
                System.out.println(cell.toString());
            }
            
        }



    }
}
