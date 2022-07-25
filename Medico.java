import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class Medico extends Persona {
    JFrame mDialog;
    Integer codigo, pacientesMes, pacientesAnual;
    String especialidad;
    Persona objPersona = new Persona();
    ProvEspe provEspe = new ProvEspe();
    MySql DB = new MySql();
    private String sql;

    public void init() {
        codigo = 0;
        pacientesMes = 0;
        pacientesAnual = 0;
        objPersona.init();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNameEsp() {
        return provEspe.getDescripcionEsp(especialidad);
    }

    public Integer getPacientesMes() {
        return pacientesMes;
    }

    public void setPacientesMes(Integer pacientesMes) {
        this.pacientesMes = pacientesMes;
    }

    public Integer getPacientesAnual() {
        return pacientesAnual;
    }

    public void setPacientesAnual(Integer pacientesAnual) {
        this.pacientesAnual = pacientesAnual;
    }

    public void listTable(DefaultTableModel table) {
        sql = "";

        table.setColumnCount(0);
        table.setRowCount(0);

        table.addColumn("Codigo");
        table.addColumn("Cedula");
        table.addColumn("Nombre");
        table.addColumn("Apellido");
        table.addColumn("Dirección");
        table.addColumn("Telefono");
        table.addColumn("Especialidad");
        table.addColumn("Paciente / Mes");
        table.addColumn("Paciente / Anual");

        Object[] row = new Object[9];

        try {

            sql = "SELECT * FROM MEDICOS, ESPECIALIDAD WHERE MEDICOS.ESPECIALIDAD = ESPECIALIDAD.CODIGO ORDER BY MEDICOS.CODIGO";
            ResultSet rs = DB.executeQuery(sql);

            while (rs.next()) {
                row[0] = rs.getString("CODIGO");
                row[1] = rs.getString("CEDULA");
                row[2] = rs.getString("NOMBRE");
                row[3] = rs.getString("APELLIDO");
                row[4] = rs.getString("DIRECCION");
                row[5] = rs.getString("TELEFONO");
                row[6] = rs.getString("DESCRIPCION");
                row[7] = rs.getString("PACIENTEMES");
                row[8] = rs.getString("PACIENTEANUAL");
                table.addRow(row);
            }
            DB.close();
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }

    }

    public boolean search(String ced) {
        boolean find = false;
        init();
        sql = "";

        try {
            sql = "SELECT * FROM MEDICOS WHERE CEDULA ='" + ced + "'";
            System.out.println(sql);
            ResultSet rs = DB.executeQuery(sql);
            cedula = ced;

            if (rs.next()) {
                codigo = Integer.parseInt(rs.getString("CODIGO"));
                objPersona.cedula = rs.getString("CEDULA");
                objPersona.nombre = rs.getString("NOMBRE");
                objPersona.apellido = rs.getString("APELLIDO");
                objPersona.dir = rs.getString("DIRECCION");
                objPersona.tel = rs.getString("TELEFONO");
                especialidad = rs.getString("ESPECIALIDAD");
                pacientesMes = Integer.parseInt(rs.getString("PACIENTEMES"));
                pacientesAnual = Integer.parseInt(rs.getString("PACIENTEANUAL"));

                find = true;
            }

            DB.close();
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
        return find;
    }

    public void add() {
        especialidad = provEspe.getCodEsp(especialidad);
        sql = "";
        try {
            sql = "INSERT INTO MEDICOS (CODIGO, CEDULA, NOMBRE, APELLIDO, DIRECCION, TELEFONO, ESPECIALIDAD, PACIENTEMES, PACIENTEANUAL) values ('"
                    + codigo + "', '" + objPersona.cedula + "', '" + objPersona.nombre + "', '" + objPersona.apellido
                    + "', '"
                    + objPersona.dir
                    + "', '" + objPersona.tel + "', '" + especialidad + "', '" + pacientesMes + "', '" + pacientesAnual
                    + "')";
            System.out.println(sql);
            DB.executeUpdate(sql);
            JOptionPane.showMessageDialog(mDialog, "Los datos se guardaron correctamente");
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
    }

    public void modify() {
        especialidad = provEspe.getCodEsp(especialidad);
        sql = "";
        try {
            sql = "UPDATE MEDICOS SET CODIGO = '" + codigo + "', NOMBRE='" + objPersona.nombre + "', APELLIDO = '"
                    + objPersona.apellido
                    + "', DIRECCION = '"
                    + objPersona.dir + "', TELEFONO = '" + objPersona.tel + "', ESPECIALIDAD =  '" + especialidad
                    + "', PACIENTEMES = " + pacientesMes + ", PACIENTEANUAL = " + pacientesAnual
                    + " WHERE CEDULA = '"
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
            sql = "DELETE FROM MEDICOS WHERE CEDULA = '" + objPersona.cedula + "'";
            System.out.println(sql);
            DB.executeUpdate(sql);
            JOptionPane.showMessageDialog(mDialog, "Los datos se Borraron correctamente");
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
    }
}
