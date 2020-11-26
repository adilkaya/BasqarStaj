package JDBC.Gun2;

import JDBC._Parent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_SqlExample extends _Parent {


    @Test
    public void  relativeExample() throws SQLException {

        ResultSet rs= statement.executeQuery("select * from city");
        rs.relative(5);
        String cityName=rs.getNString(2);
        System.out.println(cityName);


        rs.absolute(6); // 6.satıra git.
        cityName=rs.getNString(2);
        System.out.println(cityName);

    }

    @Test
    public void  lastFirstKeyword() throws SQLException {
        ResultSet rs= statement.executeQuery("select * from city");

        rs.last(); // son satira gidiyor

        String cityName=rs.getNString("city");
        Integer countryID=rs.getInt("country_id");

        System.out.println(cityName+ " -- "+ countryID);

        rs.first(); // ilk satira gidiyor

         cityName=rs.getNString("city");
         countryID=rs.getInt("country_id");


        System.out.println(cityName+ " -- "+ countryID);
    }

    @Test
    public void Task() throws SQLException {
        ResultSet rs= statement.executeQuery("select address, district from address;");

        rs.relative(10); //
        String address=rs.getNString("address");
        String district=rs.getNString("district");

        System.out.println("address -- : "+address+ " -- "+"district -- : "+ district);


        rs.relative(22); //
         address=rs.getNString("address");
         district=rs.getNString("district");

        System.out.println("address -- : "+address+ " -- "+"district -- : "+ district);

        rs.last();
         address=rs.getNString("address");
         district=rs.getNString("district");

        System.out.println("address -- : "+address+ " -- "+"district -- : "+ district);


    }


}
