import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class Paciente extends Persona {
    JFrame mDialog;
    String provincia, sexo;
    Integer edad;
    Persona objPersona = new Persona();
    ProvEspe provEspe = new ProvEspe();
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

    public String getNameProv() {
        return provEspe.getDescripcion(provincia);
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

    public void listTable(DefaultTableModel table) {
        sql = "";

        table.setColumnCount(0);
        table.setRowCount(0);

        table.addColumn("Cedula");
        table.addColumn("Nombre");
        table.addColumn("Apellido");
        table.addColumn("Dirección");
        table.addColumn("Telefono");
        table.addColumn("Provincia");
        table.addColumn("Edad");
        table.addColumn("Sexo");

        Object[] row = new Object[8];

        try {

            sql = "SELECT * FROM PACIENTES, PROVINCIA WHERE PACIENTES.PROVINCIA = PROVINCIA.CODIGO ORDER BY PACIENTES.APELLIDO";
            ResultSet rs = DB.executeQuery(sql);

            while (rs.next()) {
                row[0] = rs.getString("CEDULA");
                row[1] = rs.getString("NOMBRE");
                row[2] = rs.getString("APELLIDO");
                row[3] = rs.getString("DIRECCION");
                row[4] = rs.getString("TELEFONO");
                row[5] = rs.getString("DESCRIPCION");
                row[6] = rs.getString("EDAD");
                row[7] = rs.getString("SEXO");
                table.addRow(row);
            }
            DB.close();
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
    }

    public void add() {
        provincia = provEspe.getCodProv(provincia);
        sql = "";
        try {
            sql = "insert into pacientes(cedula,nombre,apellido,direccion,telefono, provincia, edad, sexo) values ('"
                    + objPersona.cedula + "', '" + objPersona.nombre + "', '" + objPersona.apellido + "', '"
                    + objPersona.dir
                    + "', '" + objPersona.tel + "', '" + provincia + "', '" + edad + "', '" + sexo + "')";
            System.out.println(sql);
            DB.executeUpdate(sql);
            JOptionPane.showMessageDialog(mDialog, "Los datos se guardaron correctamente");
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
    }

    public void modify() {
        provincia = provEspe.getCodProv(provincia);
        sql = "";
        try {
            sql = "UPDATE PACIENTES SET NOMBRE='" + objPersona.nombre + "', APELLIDO = '" + objPersona.apellido
                    + "', DIRECCION = '"
                    + objPersona.dir + "', TELEFONO = '" + objPersona.tel + "', PROVINCIA =  '" + provincia
                    + "', EDAD = '" + edad + "', SEXO = '" + sexo
                    + "'WHERE CEDULA = '"
                    + objPersona.cedula + "'";
            System.out.println(sql);
            DB.executeUpdate(sql);
            JOptionPane.showMessageDialog(mDialog, "Los datos se modificaron correctamente");
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
        System.out.println(sql);
    }

    public void delete() {
        sql = "";
        try {
            sql = "DELETE FROM PACIENTES WHERE CEDULA = '" + objPersona.cedula + "'";

            System.out.println(sql);
            DB.executeUpdate(sql);
            JOptionPane.showMessageDialog(mDialog, "Los datos se Borraron correctamente");
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
    }
}
