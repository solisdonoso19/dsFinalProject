import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Window implements ActionListener {
    JFrame mWindow, mDialog;
    JButton btnExit;
    JMenuBar menu;
    JMenu inicio, mantenimiento, reportes;
    JMenuItem menuInicio, menuPacientes, menuMedicos, rMedicos, rPacientes;
    JLabel info;

    public void windowPrint() {

        mWindow = new JFrame("Semestral DS3");
        mWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mWindow.setSize(1000, 1000);
        mWindow.setLayout(null);
        mWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu = new JMenuBar();
        mWindow.setJMenuBar(menu);

        inicio = new JMenu("Inicio");
        menu.add(inicio);

        mantenimiento = new JMenu("Mantenimiento");
        menu.add(mantenimiento);

        menuInicio = new JMenuItem("Inicio");
        inicio.add(menuInicio);
        menuInicio.addActionListener(this);

        menuPacientes = new JMenuItem("Pacientes");
        mantenimiento.add(menuPacientes);
        menuPacientes.addActionListener(this);

        menuMedicos = new JMenuItem("Medicos");
        mantenimiento.add(menuMedicos);
        menuMedicos.addActionListener(this);

        reportes = new JMenu("Reportes");
        menu.add(reportes);

        rPacientes = new JMenuItem("Reporte de Pacientes");
        reportes.add(rPacientes);
        rPacientes.addActionListener(this);

        rMedicos = new JMenuItem("Reporte de Medicos");
        reportes.add(rMedicos);
        rMedicos.addActionListener(this);

        mWindow.setVisible(true);
        exit();
    }

    public void exit() {
        mWindow.getContentPane().removeAll();
        btnExit = new JButton("Salir");
        btnExit.setBounds(100, 890, 1700, 50);
        btnExit.addActionListener(this);
        mWindow.add(btnExit);

        info = new JLabel("Universidad Tecnologica de Panama");
        info.setSize(250, 50);
        info.setLocation(950, 50);
        mWindow.add(info);

        info = new JLabel("Facultad de Sistemas Computacionales");
        info.setSize(250, 50);
        info.setLocation(930, 100);
        mWindow.add(info);

        info = new JLabel("Licenciatura en Desarrollo de Software");
        info.setSize(250, 50);
        info.setLocation(930, 150);
        mWindow.add(info);

        info = new JLabel("Desarrollo de Software III");
        info.setSize(250, 50);
        info.setLocation(980, 200);
        mWindow.add(info);

        info = new JLabel("Carlos Solis");
        info.setSize(100, 50);
        info.setLocation(1030, 250);
        mWindow.add(info);

        info = new JLabel("6-723-1380");
        info.setSize(100, 50);
        info.setLocation(1040, 300);
        mWindow.add(info);

        info = new JLabel("Proyecto Final Base de Datos");
        info.setSize(200, 50);
        info.setLocation(970, 350);
        mWindow.add(info);

        mWindow.revalidate();
        mWindow.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuInicio) {
            exit();
        }
        if (e.getSource() == menuMedicos) {
            new windowMed(mWindow);

        }
        if (e.getSource() == menuPacientes) {
            new windowPac(mWindow);
        }
        if (e.getSource() == rPacientes) {
            new wReportPac(mWindow);
        }
        if (e.getSource() == rMedicos) {
            new wReportMed(mWindow);
        }

        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }
}
