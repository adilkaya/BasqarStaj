package JDBC.Gun1;

import org.testng.annotations.*;

import java.sql.*;

public class _02_BeforeAfter {

    private Connection connection;
    private Statement statement;

    @BeforeTest
    public void beforeTest() throws SQLException {
        String URL = "jdbc:mysql://test.medis.mersys.io:33306/sakila";
        // Veritabanına ulaşabilmek için JDBC ye : db nini tipi (mysql), db nin yolu (test.medis.mersys.io)
        // db nin bulunduğu bilgisayarın içindeki mysql db nin port numarası (33306) ve db nin adı verildi.
        String username = "technostudy";
        String password = "zhTPis0l9#$&";

        connection = DriverManager.getConnection(URL, username, password); // bağlantı sağlandı.
        statement = connection.createStatement(); // sorgularımı çalıştırabilmek için bir yol oluştur.
    }

    @AfterTest
    public void afterTest() throws SQLException {
        connection.close();
    }

    @Test
    private void test1() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        String name= rs.getString("name");
        System.out.println(name);

        rs.next();
        name= rs.getString("name");
        System.out.println(name);

        rs.next();
         name= rs.getString("name");
        System.out.println(name);

    }

    @Test
    private void test2() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        String name= rs.getString(2); // indexler 1 den başlıyoru ,
        System.out.println(name); // colon adı yerine index kullanılabilir.

        rs.next();
        name= rs.getString(2);
        System.out.println(name);

        rs.next();
        name= rs.getString(2);
        System.out.println(name);

    }


    @Test
    private void test3() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();  // English yazdı
        String name= rs.getString(2);
        System.out.println(name);

        rs.next(); // Italian yazdı
        name= rs.getString(2);
        System.out.println(name);

        rs.previous(); // bir yukarı geri gitti kayıt göstergesi ve English yazdı
        name= rs.getString(2);
        System.out.println(name);

    }

}
