package JDBC.Gun2;

import JDBC._Parent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_GettAllRow extends _Parent {

    @Test
    public void test1() throws SQLException {

        int rowCount = 0;
        ResultSet rs = statement.executeQuery("select * from customer;");

        while (rs.next()) {
            String firstName = rs.getString("first_name");
            String lastName = rs.getNString("last_name");

            //System.out.println("firstName -- : "+firstName+ " -- "+"lastName -- : "+ lastName+ " -- "+"getRow -- : "+ rs.getRow());
            System.out.printf("%-15s %-15s %4d\n", firstName, lastName, rs.getRow());

            rowCount++;
        }
        System.out.println("kayit miktari = " + rowCount);

        rs.last();
        System.out.println(rs.getRow());

    }

    @Test
    public void task2() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM customer");
        rs.last();
        int rowCount=rs.getRow();

        rs.first();
        for (int i = 0; i < rowCount; i++) {
            String firstName = rs.getString("first_name");
            String lastName = rs.getNString("last_name");
            System.out.printf("%-15s %-15s %4d\n", firstName, lastName, rs.getRow());
            rs.next();
        }
        /* TODO 2nci bir ornek

         for (int i = 1; i <= rowCount; i++) {

            rs.absolute(i);
            String firstname=rs.getString("first_name");
            String lastname=rs.getString("last_name");
            System.out.printf("%-15s %-15s %-4d\n", firstname, lastname, rs.getRow());
        }

        TODO 3nci bir ornek
        for (int i = rowCount; i >0 ; i--) {
            rs.absolute(i);
            String firstname=rs.getString("first_name");
            String lastname=rs.getString("last_name");
            System.out.printf("%-15s %-15s %-4d\n", firstname, lastname, rs.getRow());
         */

    }
}
