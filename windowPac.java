import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class windowPac implements ActionListener {
    public JFrame windowPac;
    public DefaultListModel<String> listModel;
    public JList<String> list;
    public JScrollPane scroll;
    public JTextField txtCod, txtCed, txtName, txtLastName, txtAddress, txtTel, txtAge, txtSex, txtProv;
    public JButton btnSearch, btnList, btnAdd, btnModify, btnDelete, btnChoice, btnClean;
    public JLabel info;

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
        windowPac.add(btnAdd);

        btnModify = new JButton("Modificar");
        btnModify.setBounds(280, 775, 100, 50);
        btnModify.addActionListener(this);
        windowPac.add(btnModify);

        btnDelete = new JButton("Eliminar");
        btnDelete.setBounds(410, 775, 100, 50);
        btnDelete.addActionListener(this);
        windowPac.add(btnDelete);

        btnClean = new JButton("Limpiar");
        btnClean.setBounds(540, 775, 100, 50);
        btnClean.addActionListener(this);
        windowPac.add(btnList);

        info = new JLabel("Codigo:");
        info.setBounds(25, 820, 100, 50);
        windowPac.add(info);

        txtCod = new JTextField();
        txtCod.setBounds(80, 830, 150, 30);
        windowPac.add(txtCod);

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

        txtProv = new JTextField();
        txtProv.setBounds(1605, 830, 150, 30);
        windowPac.add(txtProv);

        listModel = new DefaultListModel<String>();
        list = new JList<String>(listModel);
        scroll = new JScrollPane();
        scroll.setBounds(20, 80, 1850, 690);
        list.add(scroll);
        windowPac.add(scroll);

        windowPac.repaint();
    }

    public void actionPerformed(ActionEvent e) {

    }
}
