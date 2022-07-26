import javax.swing.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class wReportMed implements ActionListener {
    public JFrame wReportMed;
    public JButton btnGenerate;
    public JLabel info;
    public JRadioButton ced, esp,lastName;
    public ButtonGroup rButton;
    MySql DB = new MySql();

    wReportMed(JFrame window) {
        wReportMed = window;
        wReportMed.getContentPane().removeAll();

        info = new JLabel("Seleccione el orden en el cual desea el reporte: ");
        info.setBounds(20, 20, 600, 50);
        wReportMed.add(info);

        ced = new JRadioButton("Ordenado por Cedula: ");
        ced.setBounds(20, 60, 600, 50);
        wReportMed.add(ced);

        lastName = new JRadioButton("Ordenado por Apellido: ");
        lastName.setBounds(20, 100, 600, 50);
        wReportMed.add(lastName);

        esp = new JRadioButton("Ordenado por Especialidad: ");
        esp.setBounds(20, 140, 600, 50);
        wReportMed.add(esp);

        rButton = new ButtonGroup();
        rButton.add(ced);
        rButton.add(lastName);
        rButton.add(esp);

        btnGenerate = new JButton("Generar");
        btnGenerate.setBounds(20, 200, 600, 50);
        btnGenerate.addActionListener(this);
        wReportMed.add(btnGenerate);

        wReportMed.repaint();
    }

    public void report() {
        String order;
        order = "ID";
        try {
            if (ced.isSelected()) {
                order = "CEDULA";
            } else if (lastName.isSelected()) {
                order = "APELLIDO";
            } else {
                order = "ESPECIALIDAD";
            }

            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("orden", order);
            parameter.put("titulo", order);
            JasperPrint jasperPrint = JasperFillManager.fillReport("JasperReport/MEDICOS.jasper", parameter,
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
