/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 *
 * @author JUAN PABLO
 */
public class Window {
    
    private final JFrame window;
    private JComboBox menu;
    private JLabel priLabel,makLabel,supLabel,autLabel,IDLabel;
    private JTextField priField,makField,supField,autField,IDField;
    private JTextArea resultsArea;
    private JButton searchButton;
    
    public Window(){
        window = new JFrame(); 
        initComponents();
        window.setVisible(true);
    }
    
    public void initComponents(){
        
        Font font = new Font("Montserrat",0,12);
        Color borderColor = new Color(70,70,70);
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Archivos personales\\Desktop\\Mision Tic\\Programacion\\Ciclo 2\\Semana 6\\Ejercicios\\EcoRuedasLtda\\icon\\icon.png");
        
        window.setTitle("EcoRuedasLTDA");
        window.setIconImage(icon);
        window.setFont(font);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setBounds(400,150,600,455);
        window.setResizable(false);
        window.getContentPane().setBackground(new Color(228,228,228));
        window.getContentPane().setLayout(new GridLayout(1,2));
        
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(null);
        searchPanel.setBackground(new Color(255,255,255));
        searchPanel.setBounds(0, 0, 300, 455);
        searchPanel.setBorder(BorderFactory.createLineBorder(borderColor));

        String[] options = {"Mostrar todas las motocicletas","Buscar motocicleta por precio","Buscar motocicleta por fabricante","Insertar nueva motocicleta","Actualizar motocicleta","Eliminar motocicleta"};
        
        menu = new JComboBox(options);
        menu.setBounds(23, 31, 229, 27);
        menu.setFont(font);
       
        priLabel = new JLabel("Precio");
        priLabel.setBounds(23, 94, 44, 18);
        priLabel.setFont(font);
        priLabel.setVisible(true);
        
        makLabel = new JLabel("Fabricante");
        makLabel.setBounds(23, 167,75,18);
        makLabel.setFont(font);
        makLabel.setVisible(true);
        
        supLabel = new JLabel("Proveedor");
        supLabel.setBounds(23,240,76,18);
        supLabel.setFont(font);
        supLabel.setVisible(true);
        
        autLabel = new JLabel("Autonomía");
        autLabel.setBounds(23,313,79,18);
        autLabel.setFont(font);
        autLabel.setVisible(true);
        
        priField = new JTextField();
        priField.setBounds(142,94,115,27);
        priField.setFont(font);
        priField.setVisible(true);
        
        makField = new JTextField();
        makField.setBounds(142, 167, 115, 27);
        makField.setFont(font);
        makField.setVisible(true);
        
        supField = new JTextField();
        supField.setBounds(142,240,115,27);
        supField.setFont(font);
        supField.setVisible(true);
        
        autField = new JTextField();
        autField.setBounds(142,313,115,27);
        autField.setFont(font);
        autField.setVisible(true);
        
        searchPanel.add(menu);
        searchPanel.add(priLabel);
        searchPanel.add(priField);
        searchPanel.add(makLabel);
        searchPanel.add(makField);
        searchPanel.add(supLabel);
        searchPanel.add(supField);
        searchPanel.add(autLabel);
        searchPanel.add(autField);
        
        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(null);
        resultsPanel.setBackground(new Color(255,255,255));
        JLabel resultsLabel = new JLabel("Resultados");
        resultsLabel.setFont(font);
        resultsLabel.setBounds(111, 23, 78, 18);
        resultsPanel.add(resultsLabel);
        resultsPanel.setBorder(BorderFactory.createLineBorder(borderColor));
        
        resultsArea = new JTextArea();
        resultsArea.setBounds(15, 59, 262, 340);
        resultsArea.setFont(new Font("Montserrat",0,14));
        resultsArea.setEditable(false);
        resultsArea.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);
        resultsPanel.add(resultsArea);
        
        IDLabel = new JLabel("ID");
        IDLabel.setBounds(23,360,30,18);
        IDLabel.setFont(font);
        IDLabel.setVisible(true);
        searchPanel.add(IDLabel);
        
        IDField = new JTextField();
        IDField.setBounds(63,360,30,20);
        IDField.setFont(font);
        IDField.setVisible(true);
        searchPanel.add(IDField);
        
        searchButton = new JButton("Buscar");
        searchButton.setBounds(142,360,115,20);
        searchButton.setActionCommand("Buscar");
        searchPanel.add(searchButton);
        
        window.getContentPane().add(searchPanel);
        window.getContentPane().add(resultsPanel);
        
    }
    
    public JComboBox getMenu() {
        return menu;
    }

    public JLabel getPriLabel() {
        return priLabel;
    }

    public JLabel getMakLabel() {
        return makLabel;
    }

    public JLabel getSupLabel() {
        return supLabel;
    }

    public JLabel getAutLabel() {
        return autLabel;
    }

    public JTextField getPriField() {
        return priField;
    }

    public JTextField getMakField() {
        return makField;
    }

    public JTextField getSupField() {
        return supField;
    }

    public JTextField getAutField() {
        return autField;
    }

    public JTextArea getResultsArea() {
        return resultsArea;
    }
    
    public JTextField getIDField(){
        return IDField;
    }
    public void setResultsArea(JTextArea resultsArea) {
        this.resultsArea = resultsArea;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JFrame getWindow() {
        return window;
    }
    
}
