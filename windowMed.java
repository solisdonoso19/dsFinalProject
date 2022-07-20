import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class windowMed implements ActionListener {
    public JFrame windowMeds;
    public DefaultListModel<String> listModel;
    public JList<String> list;
    public JScrollPane scroll;
    public JButton btnSearch, btnList, btnAdd, btnModify, btnDelete, btnChoice, btnClean;

    windowMed(JFrame window) {
        windowMeds = window;
        windowMeds.getContentPane().removeAll();

        btnList = new JButton("Listar");
        btnList.setBounds(100, 900, 50, 100);
        btnList.addActionListener(this);
        windowMeds.add(btnList);

        btnChoice = new JButton("Escoger");
        btnChoice.setBounds(200, 900, 50, 100);
        btnChoice.addActionListener(this);
        windowMeds.add(btnChoice);

        btnSearch = new JButton("Buscar");
        btnSearch.setBounds(100, 900, 50, 100);
        btnSearch.addActionListener(this);
        windowMeds.add(btnSearch);

        btnAdd = new JButton("Agregar");
        btnAdd.setBounds(100, 900, 50, 100);
        btnAdd.addActionListener(this);
        windowMeds.add(btnAdd);

        btnModify = new JButton("Modificar");
        btnModify.setBounds(100, 900, 50, 100);
        btnModify.addActionListener(this);
        windowMeds.add(btnModify);

        btnDelete = new JButton("Eliminar");
        btnDelete.setBounds(100, 900, 50, 100);
        btnDelete.addActionListener(this);
        windowMeds.add(btnDelete);

        btnClean = new JButton("Limpiar");
        btnClean.setBounds(100, 900, 50, 100);
        btnClean.addActionListener(this);
        windowMeds.add(btnList);

        listModel = new DefaultListModel<String>();
        list = new JList<String>(listModel);
        scroll = new JScrollPane();
        scroll.setBounds(90, 20, 100, 100);
        list.add(scroll);
        windowMeds.add(scroll);

        windowMeds.revalidate();
        windowMeds.repaint();
    }

    public void actionPerformed(ActionEvent e) {

    }
}
