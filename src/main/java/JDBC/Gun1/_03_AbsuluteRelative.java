package JDBC.Gun1;
import JDBC._Parent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsuluteRelative extends _Parent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs= statement.executeQuery("select * from film");

        rs.absolute(10); // 10.satıra git.
        String title=rs.getString("title");
        System.out.println(title);

        rs.absolute(15); // absolute verilen satıra gider.
        title=rs.getString("title");
        System.out.println(title);

        rs.relative(5); // en son bulunduğu yerden 5 ileri gider. yani 20. ye gider
        title=rs.getString("title");
        System.out.println(title);
    }


}
