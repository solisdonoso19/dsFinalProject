import java.util.*;
import javax.swing.*;
import java.sql.*;

public class ProvEspe {
    MySql DB = new MySql();
    protected String codigo, descripcion;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion(String cod) {
        String sql;
        ResultSet rs;
        try {
            sql = "SELECT * FROM PROVINCIA WHERE CODIGO = '" + cod + "'";
            rs = DB.executeQuery(sql);
            if (rs.next()) {
                codigo = rs.getString("CODIGO");
                descripcion = rs.getString("DESCRIPCION");
            }
            DB.close();
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
        return descripcion;
    }

    public String getDescripcionEsp(String cod) {
        String sql;
        ResultSet rs;
        try {
            sql = "SELECT * FROM ESPECIALIDAD WHERE CODIGO = '" + cod + "'";
            rs = DB.executeQuery(sql);
            if (rs.next()) {
                codigo = rs.getString("CODIGO");
                descripcion = rs.getString("DESCRIPCION");
            }
            DB.close();
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void listProv(JComboBox<String> combo) {
        String sql;
        ResultSet rs;

        try {
            sql = "SELECT * FROM PROVINCIA ORDER BY DESCRIPCION";
            rs = DB.executeQuery(sql);
            while (rs.next()) {
                combo.addItem(rs.getString("DESCRIPCION"));
            }
            DB.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

    }

    public void listEsp(JComboBox<String> combo) {
        String sql;
        ResultSet rs;

        try {
            sql = "SELECT * FROM ESPECIALIDAD ORDER BY DESCRIPCION";
            rs = DB.executeQuery(sql);
            while (rs.next()) {
                combo.addItem(rs.getString("DESCRIPCION"));
            }
            DB.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

    }

    public String getCodProv(String prov) {
        String cod = "";
        ResultSet rs;
        try {
            rs = DB.executeQuery("SELECT * FROM PROVINCIA WHERE DESCRIPCION = '" + prov + "';");
            if (rs.next()) {
                cod = rs.getString("CODIGO");
            }
            System.out.println(cod + "aqui");
            DB.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.toString());
        }
        return cod;
    }

    public String getCodEsp(String esp) {
        String cod = "";
        ResultSet rs;
        try {
            rs = DB.executeQuery("SELECT * FROM ESPECIALIDAD WHERE DESCRIPCION = '" + esp + "';");
            if (rs.next()) {
                cod = rs.getString("CODIGO");
            }
            System.out.println(cod + "aqui");
            DB.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.toString());
        }
        return cod;
    }
}
