import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySql {
    String URL, USER, PASS, sql, s;
    Connection con;
    Statement stmt;
    ResultSet rs;

    MySql() {
        URL = "jdbc:mysql://localhost/ds3?useSSL=false";
        USER = "root";
        PASS = "";
    }

    public void open() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
    }

    public void close() {
        try {
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            open();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
        return rs;

    }

    public void executeUpdate(String sql) {
        try {
            open();
            stmt.executeUpdate(sql);
            close();
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
    }

}
