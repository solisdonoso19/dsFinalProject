import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySql {
    String URL, USER, PASS, sql, s;
    Connection bd;
    Statement stmt;
    ResultSet view;

    MySql() {
        URL = "jdbc:mysql://localhost/ds3?useSSL=false";
        USER = "root";
        PASS = "";
    }

    public void open() {
        try {
            bd = DriverManager.getConnection(URL, USER, PASS);
            stmt = bd.createStatement();
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
    }

    // Class.forName("com.mysql.jdbc.Driver");

    public void close() {
        try {
            view.close();
            stmt.close();
            bd.close();
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            open();
            view = stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
        return view;

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
