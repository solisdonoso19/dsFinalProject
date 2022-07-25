import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class windowMed extends Medico implements ActionListener {
    public JFrame windowMeds;
    public DefaultTableModel tableModel;
    public JTable table;
    public JScrollPane scroll;
    public JTextField txtCod, txtCed, txtName, txtLastName, txtAddress, txtTel, txtMonth, txtYear;
    public JComboBox esp;
    public JButton btnSearch, btnList, btnAdd, btnModify, btnDelete, btnChoice, btnClean;
    public JLabel info;
    public ProvEspe provincia = new ProvEspe();
    public Medico medico = new Medico();

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
        btnChoice.setEnabled(false);
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
        txtCod.setEditable(false);
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
        txtName.setEditable(false);
        windowMeds.add(txtName);

        info = new JLabel("Apellido:");
        info.setBounds(475, 820, 100, 50);
        windowMeds.add(info);

        txtLastName = new JTextField();
        txtLastName.setBounds(530, 830, 150, 30);
        txtLastName.setEditable(false);
        windowMeds.add(txtLastName);

        info = new JLabel("Dirección:");
        info.setBounds(700, 820, 100, 50);
        windowMeds.add(info);

        txtAddress = new JTextField();
        txtAddress.setBounds(765, 830, 150, 30);
        txtAddress.setEditable(false);
        windowMeds.add(txtAddress);

        info = new JLabel("Teléfono:");
        info.setBounds(925, 820, 100, 50);
        windowMeds.add(info);

        txtTel = new JTextField();
        txtTel.setBounds(985, 830, 150, 30);
        txtTel.setEditable(false);
        windowMeds.add(txtTel);

        info = new JLabel("medico/Mes:");
        info.setBounds(1150, 820, 100, 50);
        windowMeds.add(info);

        txtMonth = new JTextField();
        txtMonth.setBounds(1245, 830, 150, 30);
        txtMonth.setEditable(false);
        windowMeds.add(txtMonth);

        info = new JLabel("Paciente/Year:");
        info.setBounds(1400, 820, 100, 50);
        windowMeds.add(info);

        txtYear = new JTextField();
        txtYear.setBounds(1495, 830, 150, 30);
        txtYear.setEditable(false);
        windowMeds.add(txtYear);

        info = new JLabel("Especialidad:");
        info.setBounds(1650, 820, 100, 50);
        windowMeds.add(info);

        esp = new JComboBox();
        esp.setBounds(1735, 830, 150, 30);
        provincia.listEsp(esp);
        esp.setEnabled(false);
        windowMeds.add(esp);
        windowMeds.add(esp);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        scroll = new JScrollPane(table);
        scroll.setBounds(20, 80, 1850, 690);
        windowMeds.add(scroll);

        windowMeds.repaint();
    }

    public void search() {
        if (medico.search(txtCed.getText())) {
            btnModify.setEnabled(true);
            btnDelete.setEnabled(true);
            btnClean.setEnabled(true);
            txtCed.setEditable(false);
            btnAdd.setEnabled(false);

        } else {
            btnModify.setEnabled(false);
            btnDelete.setEnabled(false);
            btnAdd.setEnabled(true);
            btnClean.setEnabled(true);

            txtEditableT();

        }

        txtCed.setText(medico.objPersona.getCedula());
        txtCod.setText(String.valueOf(medico.getCodigo()));
        txtName.setText(medico.objPersona.getNombre());
        txtLastName.setText(medico.objPersona.getApellido());
        txtAddress.setText(medico.objPersona.getDir());
        txtTel.setText(medico.objPersona.getTel());
        esp.setSelectedItem(medico.getNameEsp());
        txtMonth.setText(String.valueOf(medico.getPacientesMes()));
        txtYear.setText(String.valueOf(medico.getPacientesAnual()));
    }

    public void add() {
        medico.objPersona.setCedula(txtCed.getText());
        medico.setCodigo(Integer.parseInt(txtCod.getText()));
        medico.objPersona.setNombre(txtName.getText());
        medico.objPersona.setApellido(txtLastName.getText());
        medico.objPersona.setDir(txtAddress.getText());
        medico.objPersona.setTel(txtTel.getText());
        medico.setEspecialidad(String.valueOf(esp.getSelectedItem()));
        medico.setPacientesMes(Integer.parseInt(txtMonth.getText()));
        medico.setPacientesAnual(Integer.parseInt(txtYear.getText()));
        medico.add();
        txtEditableF();
        clean();
        btnAdd.setEnabled(false);
        btnClean.setEnabled(false);
    }

    public void modify() {
        medico.objPersona.setCedula(txtCed.getText());
        medico.setCodigo(Integer.parseInt(txtCod.getText()));
        medico.objPersona.setNombre(txtName.getText());
        medico.objPersona.setApellido(txtLastName.getText());
        medico.objPersona.setDir(txtAddress.getText());
        medico.objPersona.setTel(txtTel.getText());
        medico.setEspecialidad(String.valueOf(esp.getSelectedItem()));
        medico.setPacientesMes(Integer.parseInt(txtMonth.getText()));
        medico.setPacientesAnual(Integer.parseInt(txtYear.getText()));
        medico.modify();
    }

    public void txtEditableF() {
        txtCed.setEditable(true);
        txtCod.setEditable(false);
        txtName.setEditable(false);
        txtLastName.setEditable(false);
        txtAddress.setEditable(false);
        txtTel.setEditable(false);
        esp.setEnabled(false);
        txtMonth.setEditable(false);
        txtYear.setEditable(false);
    }

    public void txtEditableT() {
        txtCod.setEditable(true);
        txtName.setEditable(true);
        txtLastName.setEditable(true);
        txtAddress.setEditable(true);
        txtTel.setEditable(true);
        esp.setEnabled(true);
        txtMonth.setEditable(true);
        txtYear.setEditable(true);
    }

    public void delete() {
        medico.objPersona.setCedula(txtCed.getText());
        medico.delete();
        btnModify.setEnabled(false);
        btnDelete.setEnabled(false);
        clean();
    }

    public void clean() {
        txtCod.setText(" ");
        txtCed.setText(" ");
        txtName.setText(" ");
        txtLastName.setText(" ");
        txtAddress.setText(" ");
        txtTel.setText(" ");
        esp.setSelectedItem(" ");
        txtMonth.setText(" ");
        txtYear.setText(" ");
        btnAdd.setEnabled(false);
        btnClean.setEnabled(false);
        txtEditableF();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnList) {
            medico.listTable(tableModel);
            btnChoice.setEnabled(true);
        }
        if (e.getSource() == btnChoice) {
            int row;
            row = table.getSelectedRow();
            txtCed.setText(String.valueOf(table.getValueAt(row, 1)));
            search();
            txtEditableT();
        }
        if (e.getSource() == btnSearch) {
            search();
        }
        if (e.getSource() == btnAdd) {
            add();
        }
        if (e.getSource() == btnDelete) {
            delete();
        }
        if (e.getSource() == btnModify) {
            modify();
        }
        if (e.getSource() == btnClean) {
            clean();
            btnModify.setEnabled(false);
            btnDelete.setEnabled(false);
        }
    }
}
