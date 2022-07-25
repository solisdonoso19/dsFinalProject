import javax.swing.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.WriteAbortedException;
import java.rmi.RemoteException;

public class wReportPac implements ActionListener {
    public JFrame wReportPac;
    public JButton btnGenerate;
    public JLabel info;
    public JRadioButton name, age, lastName;
    public ButtonGroup rButton;
    MySql DB = new MySql();

    wReportPac(JFrame window) {
        wReportPac = window;
        wReportPac.getContentPane().removeAll();

        info = new JLabel("Seleccione el orden en el cual desea el reporte: ");
        info.setBounds(20, 20, 600, 50);
        wReportPac.add(info);

        name = new JRadioButton("Ordenado por Nombre: ");
        name.setBounds(20, 60, 600, 50);
        wReportPac.add(name);

        lastName = new JRadioButton("Ordenado por Apellido: ");
        lastName.setBounds(20, 100, 600, 50);
        wReportPac.add(lastName);

        age = new JRadioButton("Ordenado por Edad: ");
        age.setBounds(20, 140, 600, 50);
        wReportPac.add(age);

        rButton = new ButtonGroup();
        rButton.add(name);
        rButton.add(lastName);
        rButton.add(age);

        btnGenerate = new JButton("Generar");
        btnGenerate.setBounds(20, 200, 600, 50);
        btnGenerate.addActionListener(this);
        wReportPac.add(btnGenerate);

        wReportPac.repaint();
    }

    public void report() {
        String order;
        order = "ID";
        try {
            if (name.isSelected()) {
                order = "NOMBRE";
            } else if (lastName.isSelected()) {
                order = "APELLIDO";
            } else {
                order = "EDAD";
            }

            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("orden", order);
            parameter.put("titulo", order);
            JasperPrint jasperPrint = JasperFillManager.fillReport("JasperReport/PACIENTES.jasper", parameter,
                    DB.getConnetion());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);
            DB.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGenerate) {
            report();
        }
    }
}
