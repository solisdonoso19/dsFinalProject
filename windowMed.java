import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class windowMed extends Medico implements ActionListener {
    public JFrame windowMeds;
    public DefaultListModel<String> listModel;
    public JList<String> list;
    public JScrollPane scroll;
    public JTextField txtCod, txtCed, txtName, txtLastName, txtAddress, txtTel, txtMonth, txtYear;
    public JComboBox esp;
    public JButton btnSearch, btnList, btnAdd, btnModify, btnDelete, btnChoice, btnClean;
    public JLabel info;

    windowMed(JFrame window) {
        windowMeds = window;
        windowMeds.getContentPane().removeAll();

        info = new JLabel("Información de Médicos");
        info.setBounds(850, 20, 200, 50);
        windowMeds.add(info);

        btnList = new JButton("Listar");
        btnList.setBounds(20, 20, 100, 50);
        btnList.addActionListener(this);
        windowMeds.add(btnList);

        btnChoice = new JButton("Escoger");
        btnChoice.setBounds(150, 20, 100, 50);
        btnChoice.addActionListener(this);
        windowMeds.add(btnChoice);

        btnSearch = new JButton("Buscar");
        btnSearch.setBounds(20, 775, 100, 50);
        btnSearch.addActionListener(this);
        windowMeds.add(btnSearch);

        btnAdd = new JButton("Agregar");
        btnAdd.setBounds(150, 775, 100, 50);
        btnAdd.addActionListener(this);
        btnAdd.setEnabled(false);
        windowMeds.add(btnAdd);

        btnModify = new JButton("Modificar");
        btnModify.setBounds(280, 775, 100, 50);
        btnModify.addActionListener(this);
        btnModify.setEnabled(false);
        windowMeds.add(btnModify);

        btnDelete = new JButton("Eliminar");
        btnDelete.setBounds(410, 775, 100, 50);
        btnDelete.addActionListener(this);
        btnDelete.setEnabled(false);
        windowMeds.add(btnDelete);

        btnClean = new JButton("Limpiar");
        btnClean.setBounds(540, 775, 100, 50);
        btnClean.addActionListener(this);
        btnClean.setEnabled(false);
        windowMeds.add(btnClean);

        info = new JLabel("Codigo:");
        info.setBounds(25, 820, 100, 50);
        windowMeds.add(info);

        txtCod = new JTextField();
        txtCod.setBounds(80, 830, 150, 30);
        windowMeds.add(txtCod);

        info = new JLabel("Cedula:");
        info.setBounds(25, 860, 100, 50);
        windowMeds.add(info);

        txtCed = new JTextField();
        txtCed.setBounds(80, 870, 150, 30);
        windowMeds.add(txtCed);

        info = new JLabel("Nombre:");
        info.setBounds(250, 820, 100, 50);
        windowMeds.add(info);

        txtName = new JTextField();
        txtName.setBounds(305, 830, 150, 30);
        windowMeds.add(txtName);

        info = new JLabel("Apellido:");
        info.setBounds(475, 820, 100, 50);
        windowMeds.add(info);

        txtLastName = new JTextField();
        txtLastName.setBounds(530, 830, 150, 30);
        windowMeds.add(txtLastName);

        info = new JLabel("Dirección:");
        info.setBounds(700, 820, 100, 50);
        windowMeds.add(info);

        txtAddress = new JTextField();
        txtAddress.setBounds(765, 830, 150, 30);
        windowMeds.add(txtAddress);

        info = new JLabel("Teléfono:");
        info.setBounds(925, 820, 100, 50);
        windowMeds.add(info);

        txtTel = new JTextField();
        txtTel.setBounds(985, 830, 150, 30);
        windowMeds.add(txtTel);

        info = new JLabel("Paciente/Mes:");
        info.setBounds(1150, 820, 100, 50);
        windowMeds.add(info);

        txtMonth = new JTextField();
        txtMonth.setBounds(1245, 830, 150, 30);
        windowMeds.add(txtMonth);

        info = new JLabel("Paciente/Year:");
        info.setBounds(1400, 820, 100, 50);
        windowMeds.add(info);

        txtYear = new JTextField();
        txtYear.setBounds(1495, 830, 150, 30);
        windowMeds.add(txtYear);

        info = new JLabel("Especialidad:");
        info.setBounds(1650, 820, 100, 50);
        windowMeds.add(info);

        esp = new JComboBox();
        esp.setBounds(1735, 830, 150, 30);
        esp.addItem("");
        esp.addItem("Medico General");
        esp.addItem("Interno");
        esp.addItem("Cirujano");
        esp.addItem("Pediatra");
        esp.addItem("Psiquiatra");
        esp.addItem("Dermatologo");
        esp.addItem("Dentista");
        esp.addItem("Reumatologo");
        esp.addItem("Oftamologo");
        esp.addItem("Ginecologo");
        windowMeds.add(esp);

        listModel = new DefaultListModel<String>();
        list = new JList<String>(listModel);
        scroll = new JScrollPane();
        scroll.setBounds(20, 80, 1850, 690);
        list.add(scroll);
        windowMeds.add(scroll);

        windowMeds.repaint();
    }

    public void actionPerformed(ActionEvent e) {

    }
}
