import java.security.Principal;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class Paciente extends Persona {

    String provincia, sexo;
    Integer edad;
    Persona objPersona = new Persona();
    MySql DB = new MySql();
    private String sql;

    public void init() {
        provincia = "";
        sexo = "";
        edad = 0;
        objPersona.init();
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public boolean search(String ced) {
        boolean find = false;
        init();
        sql = "";

        try {
            sql = "select * from pacientes where cedula='" + ced + "'";
            System.out.println(sql);
            ResultSet rs = DB.executeQuery(sql);
            cedula = ced;

            if (rs.next()) {
                objPersona.cedula = rs.getString("cedula");
                objPersona.nombre = rs.getString("nombre");
                objPersona.apellido = rs.getString("apellido");
                objPersona.dir = rs.getString("direccion");
                objPersona.tel = rs.getString("telefono");
                provincia = rs.getString("provincia");
                edad = Integer.parseInt(rs.getString("edad"));
                sexo = rs.getString("sexo");

                find = true;
            }

            DB.close();
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
        return find;
    }

    /*
     * public void listar(DefaultTableModel dtm)
     * {
     * sql = "";
     * 
     * dtm.setColumnCount(0);
     * dtm.setRowCount(0);
     * 
     * dtm.addColumn("Cedula");
     * dtm.addColumn("Nombre");
     * dtm.addColumn("Apellido");
     * dtm.addColumn("Provincia");
     * 
     * Object[] fila = new Object[4];
     * 
     * try
     * {
     * 
     * sql =
     * "select * from cliente,provincia where cliente.provincia = provincia.codigo";
     * ResultSet rs = db.executeQuery(sql);
     * 
     * while (rs.next())
     * {
     * fila[0] = rs.getString("cedula");
     * fila[1] = rs.getString("nombre");
     * fila[2] = rs.getString("apellido");
     * fila[3] = rs.getString("descripcion");
     * dtm.addRow(fila);
     * }
     * db.cerrar();
     * }
     * catch(Exception e)
     * {
     * System.out.println("error "+e.toString());
     * }
     * }
     */

    public void add() {
        sql = "";
        try {
            sql = "insert into pacientes(cedula,nombre,apellido,direccion,telefono, edad,sexo) values ("
                    + objPersona.cedula + ", " + objPersona.nombre + ", " + objPersona.apellido + ", " + objPersona.tel
                    + ", " + objPersona.dir + ", " + edad + ", " + sexo + ")";
            System.out.println(sql);
            DB.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
    }
}
