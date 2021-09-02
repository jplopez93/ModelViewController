/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ElectricMotorcycles;
import access.DAOElectricMotorcycles;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Window;


/**
 *
 * @author JUAN PABLO
 */
public class Controller implements ActionListener{

    private Window window;
    private DAOElectricMotorcycles motos;
    
    public Controller(){
        
        window = new Window();
        motos = new DAOElectricMotorcycles();
        listeners();
    }
    
    public void listeners(){
        window.getSearchButton().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent action){
        String res = "";
        String command = action.getActionCommand();
        Object selected = window.getMenu().getSelectedItem();
        System.out.println(selected);
        
        if(selected.equals("Mostrar todas las motocicletas")){  
            for(ElectricMotorcycles moto: motos.getMotorcycles()){
                        res += moto.toString();
            }
            window.getResultsArea().setText(res);
        }
        
        else if(selected.equals("Buscar motocicleta por precio")){
            int price;
            ElectricMotorcycles moto;
            if(!window.getPriField().getText().equals("")){
               
                price =Integer.parseInt(window.getPriField().getText());
                
                moto = motos.getMoto(price);
                if(moto != null){
                    window.getResultsArea().setText(moto.toString());
                }else{
                    window.getResultsArea().setText("No se encontró una moto \ncon ese precio");
                }
            }else{
                window.getResultsArea().setText("Ingrese un precio");
            }
            
        }
        
        else if(selected.equals("Buscar motocicleta por fabricante")){
            String maker = window.getMakField().getText();
            ElectricMotorcycles moto = motos.getMoto(maker);
            if(moto != null){
                window.getResultsArea().setText(moto.toString());
            }else{
                window.getResultsArea().setText("No se encontró una moto\n de ese fabricante");
            }
        }
        
        else if(selected.equals("Insertar nueva motocicleta")){
            ElectricMotorcycles moto = null;
            int price = Integer.parseInt(window.getPriField().getText());
            String maker = window.getMakField().getText();
            String supplier = window.getSupField().getText();
            int idSup = 0;
            switch(supplier){
                case "Auteco": idSup = 101; break;
                case "Hitachi": idSup = 102; break;
                case "Bosch": idSup = 103; break;
                case "Teco": idSup = 104; break;
                case "General Electric": idSup = 105; break;
            }
            int autonomy = Integer.parseInt(window.getAutField().getText());
            int id = Integer.parseInt(window.getIDField().getText());
            moto = new ElectricMotorcycles(id,maker,price,autonomy,idSup);
            motos.insertMoto(moto);  
        }
        
        else if(selected.equals("Actualizar motocicleta")){
            ElectricMotorcycles moto = null;
            int price = Integer.parseInt(window.getPriField().getText());
            String maker = window.getMakField().getText();
            String supplier = window.getSupField().getText();
            int idSup = 0;
            switch(supplier){
                case "Auteco": idSup = 101; break;
                case "Hitachi": idSup = 102; break;
                case "Bosch": idSup = 103; break;
                case "Teco": idSup = 104; break;
                case "General Electric": idSup = 105; break;
            }
            int autonomy = Integer.parseInt(window.getAutField().getText());
            int id = Integer.parseInt(window.getIDField().getText());
            moto = new ElectricMotorcycles(id,maker,price,autonomy,idSup);
            motos.updateMotoName(moto);
            motos.updateMotoPrice(moto);
        }
        
        else if(selected.equals("Eliminar motocicleta")){
            ElectricMotorcycles moto = null;
            int id = Integer.parseInt(window.getIDField().getText());
            int question = JOptionPane.showInternalConfirmDialog(null,"Esta seguro?");
            if(question == 0){
                motos.deleteMoto(id);
            }else{
                window.getResultsArea().setText("No se eliminó la motocicleta");
            }
        }
        
    }
    
   
    
    public static void main(String[] args) {
        new Controller();
    }
   
}
