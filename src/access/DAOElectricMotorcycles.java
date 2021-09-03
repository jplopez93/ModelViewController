/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import util.ConnectionDB;
import model.ElectricMotorcycles;

/**
 *
 * @author JUAN PABLO
 */
public class DAOElectricMotorcycles {
    private Connection conn = null;
    
    // Consultas
    
    public ArrayList<ElectricMotorcycles>getMotorcycles(){
        
        ArrayList<ElectricMotorcycles> motorcycles = new ArrayList<>();
        try {
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "SELECT idmotocicleta, nom_fab, precio, autonomia, proveedor FROM motocicletas_electricas;";
            
            Statement command = conn.createStatement();
            ResultSet result = command.executeQuery(sql);
            
            while(result.next()){
                ElectricMotorcycles moto = new ElectricMotorcycles(result.getInt(1),result.getString(2),result.getInt(3),result.getInt(4),result.getInt(5));
                motorcycles.add(moto);
            }
            
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error al obtener \n todas las motos eléctricas" );
        }
        
        return motorcycles;
    }
    
    public ElectricMotorcycles getMoto(String producerName){
        
        ElectricMotorcycles moto = null;
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "SELECT nom_fab, precio FROM motocicletas_electricas where nom_fab =?;";
            
            PreparedStatement command = conn.prepareStatement(sql);
            command.setString(1, producerName);
            ResultSet result = command.executeQuery();
            
            while (result.next()) {
                moto = new ElectricMotorcycles(result.getString(1),result.getInt(2));
                break;
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error al obtener \n la motocicleta eléctrica");
        }
        
        return moto;
    }
    
    public ElectricMotorcycles getMoto(int price){
        
        ElectricMotorcycles moto = null;
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "SELECT nom_fab, precio FROM motocicletas_electricas where precio =?;";
            
            PreparedStatement command = conn.prepareStatement(sql);
            command.setInt(1, price);
            ResultSet result = command.executeQuery();
            
            while (result.next()) {
                moto = new ElectricMotorcycles(result.getString(1),result.getInt(2));
                break;
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error al obtener \n la motocicleta eléctrica");
        }
        
        return moto;
    }
    
    //Insert
    
    public void insertMoto(ElectricMotorcycles moto){
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "INSERT INTO motocicletas_electricas(idmotocicleta,nom_fab,precio,autonomia,proveedor) VALUES (?,?,?,?,?);";
            
            PreparedStatement command = conn.prepareStatement(sql);
            command.setInt(1, moto.getId());
            command.setString(2, moto.getProducerName());
            command.setInt(3, moto.getPrice());
            command.setInt(4, moto.getAutonomy());
            command.setInt(5, moto.getSupplier());
            int insertedRows = command.executeUpdate();
            
            if(insertedRows > 0){
                JOptionPane.showMessageDialog(null,"La motocicleta se ha añadido correctamente");
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error al insertar la motocicleta");
        }
        
    }
    
    //Delete
    public void deleteMoto(int id){
        try{
            if(conn == null){
            conn = ConnectionDB.getConnection();
            }
        
            String sql = "DELETE FROM motocicletas_electricas WHERE idmotocicleta = ?;";
            PreparedStatement command = conn.prepareStatement(sql);
            command.setInt(1, id);
            int deletedRows = command.executeUpdate();

            if(deletedRows > 0){
                JOptionPane.showMessageDialog(null,"Se ha eliminado la motocicleta correctamente");
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al eliminar la motocicleta");
        }
    }
    
    //Updates
    public void updateMoto(ElectricMotorcycles moto){
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "UPDATE motocicletas_electricas SET nom_fab=?,precio=?,autonomia=? where idmotocicleta=?;";
            PreparedStatement command = conn.prepareStatement(sql);
            command.setString(1, moto.getProducerName());
            command.setInt(2, moto.getPrice());
            command.setInt(3, moto.getAutonomy());
            command.setInt(4, moto.getId());
            int updatedRows = command.executeUpdate();
            
            if(updatedRows > 0){
                JOptionPane.showMessageDialog(null,"La motocicleta se actualizó correctamente");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Hubo un error al actualizar el nombre de la motocicleta");
        }
    }
}
