import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class windowPac extends Paciente implements ActionListener {
    public JFrame windowPac;
    public DefaultListModel<String> listModel;
    public JList<String> list;
    public JScrollPane scroll;
    public JTextField txtCed, txtName, txtLastName, txtAddress, txtTel, txtAge, txtSex;
    public JComboBox prov;
    public JButton btnSearch, btnList, btnAdd, btnModify, btnDelete, btnChoice, btnClean;
    public JLabel info;
    public Paciente paciente = new Paciente();

    windowPac(JFrame window) {
        windowPac = window;
        windowPac.getContentPane().removeAll();

        info = new JLabel("Información de Pacientes");
        info.setBounds(850, 20, 200, 50);
        windowPac.add(info);

        btnList = new JButton("Listar");
        btnList.setBounds(20, 20, 100, 50);
        btnList.addActionListener(this);
        windowPac.add(btnList);

        btnChoice = new JButton("Escoger");
        btnChoice.setBounds(150, 20, 100, 50);
        btnChoice.addActionListener(this);
        windowPac.add(btnChoice);

        btnSearch = new JButton("Buscar");
        btnSearch.setBounds(20, 775, 100, 50);
        btnSearch.addActionListener(this);
        windowPac.add(btnSearch);

        btnAdd = new JButton("Agregar");
        btnAdd.setBounds(150, 775, 100, 50);
        btnAdd.addActionListener(this);
        btnAdd.setEnabled(false);
        windowPac.add(btnAdd);

        btnModify = new JButton("Modificar");
        btnModify.setBounds(280, 775, 100, 50);
        btnModify.addActionListener(this);
        btnModify.setEnabled(false);
        windowPac.add(btnModify);

        btnDelete = new JButton("Eliminar");
        btnDelete.setBounds(410, 775, 100, 50);
        btnDelete.addActionListener(this);
        btnDelete.setEnabled(false);
        windowPac.add(btnDelete);

        btnClean = new JButton("Limpiar");
        btnClean.setBounds(540, 775, 100, 50);
        btnClean.addActionListener(this);
        btnClean.setEnabled(false);
        windowPac.add(btnClean);

        info = new JLabel("Cedula:");
        info.setBounds(25, 820, 100, 50);
        windowPac.add(info);

        txtCed = new JTextField();
        txtCed.setBounds(80, 830, 150, 30);
        windowPac.add(txtCed);

        info = new JLabel("Nombre:");
        info.setBounds(250, 820, 100, 50);
        windowPac.add(info);

        txtName = new JTextField();
        txtName.setBounds(305, 830, 150, 30);
        windowPac.add(txtName);

        info = new JLabel("Apellido:");
        info.setBounds(475, 820, 100, 50);
        windowPac.add(info);

        txtLastName = new JTextField();
        txtLastName.setBounds(530, 830, 150, 30);
        windowPac.add(txtLastName);

        info = new JLabel("Dirección:");
        info.setBounds(700, 820, 100, 50);
        windowPac.add(info);

        txtAddress = new JTextField();
        txtAddress.setBounds(765, 830, 150, 30);
        windowPac.add(txtAddress);

        info = new JLabel("Teléfono:");
        info.setBounds(925, 820, 100, 50);
        windowPac.add(info);

        txtTel = new JTextField();
        txtTel.setBounds(985, 830, 150, 30);
        windowPac.add(txtTel);

        info = new JLabel("Edad:");
        info.setBounds(1150, 820, 100, 50);
        windowPac.add(info);

        txtAge = new JTextField();
        txtAge.setBounds(1190, 830, 150, 30);
        windowPac.add(txtAge);

        info = new JLabel("Sexo:");
        info.setBounds(1350, 820, 100, 50);
        windowPac.add(info);

        txtSex = new JTextField();
        txtSex.setBounds(1385, 830, 150, 30);
        windowPac.add(txtSex);

        info = new JLabel("Provincia:");
        info.setBounds(1545, 820, 100, 50);
        windowPac.add(info);

        prov = new JComboBox();
        prov.setBounds(1605, 830, 150, 30);
        prov.addItem("");
        prov.addItem("Bocas Del Toro");
        prov.addItem("Chiriqui");
        prov.addItem("Colon");
        prov.addItem("Cocle");
        prov.addItem("Darien");
        prov.addItem("Herrera");
        prov.addItem("Los Santos");
        prov.addItem("Panama");
        prov.addItem("Veraguas");
        prov.addItem("Panama Oeste");
        windowPac.add(prov);

        listModel = new DefaultListModel<String>();
        list = new JList<String>(listModel);
        scroll = new JScrollPane();
        scroll.setBounds(20, 80, 1850, 690);
        list.add(scroll);
        windowPac.add(scroll);

        windowPac.repaint();
    }

    public void search() {
        if (paciente.search(txtCed.getText())) {
            btnModify.setEnabled(true);
            btnDelete.setEnabled(true);
            btnClean.setEnabled(true);
            btnAdd.setEnabled(false);
        } else {
            btnModify.setEnabled(false);
            btnDelete.setEnabled(false);
            btnAdd.setEnabled(true);
        }
        txtCed.setText(paciente.objPersona.getCedula());
        txtName.setText(paciente.objPersona.getNombre());
        txtLastName.setText(paciente.objPersona.getApellido());
        txtAddress.setText(paciente.objPersona.getDir());
        txtTel.setText(paciente.objPersona.getTel());
        // prov.setSelectedItem(paciente.getProvincia());
        txtAge.setText(String.valueOf(paciente.getEdad()));
        txtSex.setText(paciente.getSexo());
    }

    public void add() {
        paciente.objPersona.setCedula(txtCed.getText());
        paciente.objPersona.setNombre(txtName.getText());
        paciente.objPersona.setApellido(txtLastName.getText());
        paciente.objPersona.setDir(txtAddress.getText());
        paciente.objPersona.setTel(txtTel.getText());
        // paciente.provincia(prov.getSelectedItem());
        paciente.setEdad(Integer.parseInt(txtAge.getText()));
        paciente.setSexo(txtSex.getText());
        paciente.add();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            search();
        }
        if (e.getSource() == btnAdd) {
            add();
        }
    }
}
