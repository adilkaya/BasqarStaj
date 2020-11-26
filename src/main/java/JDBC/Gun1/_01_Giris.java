package JDBC.Gun1;

import org.testng.annotations.*;
import java.sql.*;

public class _01_Giris {




    @Test
    public void test1() throws SQLException {
        String url = "jdbc:mysql://test.medis.mersys.io:33306/sakila";
        // Veritabanına ulaşabilmek için JDBC ye : db nini tipi (mysql), db nin yolu (test.medis.mersys.io)
        // db nin bulunduğu bilgisayarın içindeki mysql db nin port numarası (33306) ve db nin adı verildi.
        String username = "technostudy";
        String password = "zhTPis0l9#$&";

        Connection connection = DriverManager.getConnection(url, username, password); // bağlantı sağlandı.
        Statement statement = connection.createStatement(); // sorgularımı çalıştırabilmek için bir yol oluştur.

        ResultSet rs= statement.executeQuery("select * from actor"); // çalıştırıldı sonuçlar rs değişkenine set edildi.
        // fakat performans için bütün sonuçlar bir anda rs ye aktarılmıyor. Biz komut verdikçe satır satır gelecek.

        // 1.satır
        rs.next();  // göstergeyi sonraki adıma getir, orada satır varsa, bütün satırı rs ye at.

        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");

        System.out.println(firstName+" "+lastName);

        // 2.satır
        rs.next();  // göstergeyi sonraki adıma getir, orada satır varsa, bütün satırı rs ye at.

        firstName = rs.getString("first_name");
        lastName = rs.getString("last_name");

        System.out.println(firstName+" "+lastName);

        connection.close();
    }


}
