import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Window implements ActionListener {
    JFrame mWindow, mDialog;
    JButton btnSearch, btnList, btnAdd, btnModify, btnDelete, btnChoice;
    JMenuBar menu;
    JMenu inicio, mantenimiento;
    JMenuItem menuInicio, menuPacientes, menuMedicos;

    public void windowPrint() {
        mWindow = new JFrame("Semestral DS3");
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
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuInicio) {
            System.out.println("HOLA");
        }
    }
}
