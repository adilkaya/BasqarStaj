package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    //verilen bir db ye ait sorgunun sonucunu bir liste atarak geri döndüren metodu yazınız.
    // URL,username,password, db, sql  parametre olarak alacak


    public static List<List<String>> getListData(String query)
    {
        String URL = "jdbc:mysql://test.medis.mersys.io:33306/ts_ismet1";
        // Veritabanına ulaşabilmek için JDBC ye : db nini tipi (mysql), db nin yolu (test.medis.mersys.io)
        // db nin bulunduğu bilgisayarın içindeki mysql db nin port numarası (33306) ve db nin adı verildi.
        String username = "technostudy";
        String password = "zhTPis0l9#$&";

        List<List<String>> donecekList=new ArrayList<>();

        // burada try-catch kullanmamızın sebebi, alternatif olarak metoda exception imzası eklense idi,
        // bu metodu çağıran her metodun kendisine de eklenmesi zorunlu olacaktı. burada lokal try-catch
        // kullanarak bu mecburiyetten kurtulmuş olduk.
        try {
            Connection connection = DriverManager.getConnection(URL, username, password);
            Statement statement = connection.createStatement(); // sorgularımı çalıştırabilmek için bir yol oluştur.

            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();  // sorgu listesine ilşkin temel bilgilere ulaşabiliyoruz bu fonksiyon ile.
            int columnCount = rsmd.getColumnCount(); // column sayısına ulaştık

            while (rs.next()) {
                List<String> rowList = new ArrayList<>();

                for (int i = 1; i <= columnCount; i++) {
                    rowList.add(rs.getString(i));
                }

                donecekList.add(rowList);
            }
            connection.close();


        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return donecekList;
    }


    public static void main(String[] args) {
        List<List<String>> gelenList = getListData("select * from language");
        System.out.println(gelenList);

        gelenList = getListData("select * from city");
        System.out.println(gelenList);
    }

}


