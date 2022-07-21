import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Window implements ActionListener {
    JFrame mWindow, mDialog;
    JButton btnSearch, btnList, btnAdd, btnModify, btnDelete, btnChoice, btnExit;
    JMenuBar menu;
    JMenu inicio, mantenimiento;
    JMenuItem menuInicio, menuPacientes, menuMedicos;

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

        mWindow.setVisible(true);

        exit();
    }

    public void exit() {
        mWindow.getContentPane().removeAll();
        btnExit = new JButton("Salir");
        btnExit.setBounds(100, 890, 1700, 50);
        btnExit.addActionListener(this);
        mWindow.add(btnExit);
        mWindow.revalidate();
        mWindow.repaint();
    }

    public void hola() {
        mWindow.getContentPane().removeAll();
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
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }
}
