package JDBC.Gun2;

import JDBC._Parent;
import org.testng.annotations.Test;

import java.awt.image.RescaleOp;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _03_GetAllRowColumn extends _Parent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from category;");

        int rowCount = 0;

        while (rs.next()) {
            String name = rs.getString(2);
            //System.out.println("name -- : "+name);

            System.out.printf("%-15s %4d\n", name, rs.getRow());
            rowCount++;
        }
        System.out.println("catagory sayisi = " + rowCount);

        rs.last();
        System.out.println(rs.getRow());

    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language;");

        ResultSetMetaData rsmd=rs.getMetaData();
        int columnCount=rsmd.getColumnCount();
        System.out.println(columnCount+ "columncount");

        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i)+" ");
            }
            System.out.println();
        }

    }

    @Test
    public void test3() throws SQLException {
       // ResultSet rs = statement.executeQuery("select title, rental_rate, special_features from film;");
        ResultSet rs = statement.executeQuery("select * from film;");
        ResultSetMetaData rsmd=rs.getMetaData();
        int columnCount=rsmd.getColumnCount();
        System.out.println(columnCount+ "columncount");

        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i)+" ");
                //System.out.printf("%-15s %4d\n", rs.getString(i), rs.getRow());
            }
            System.out.println();
        }
    }


    @Test
    public void test4() throws SQLException {
        // ResultSet rs = statement.executeQuery("select title, rental_rate, special_features from film;");
        ResultSet rs = statement.executeQuery("select * from film;");
        ResultSetMetaData rsmd=rs.getMetaData();
        int columnCount=rsmd.getColumnCount();
        System.out.println(columnCount+ "columncount");

        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%s " ,rs.getString(i));
                //System.out.printf("%-15s %4d\n", rs.getString(i), rs.getRow());
            }
            System.out.println();
        }
}}