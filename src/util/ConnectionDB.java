/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author JUAN PABLO
 */
public class ConnectionDB {
    
    public static Connection getConnection(){
        Connection conn = null;
        
        try{
            
            String DBurl = "jdbc:mysql://127.0.0.1:3306/ecoruedasltda";
            conn = DriverManager.getConnection(DBurl,"root","root");
            
        }catch(SQLException ex){
            ex.printStackTrace();
        } 
        return conn;
    }
    
    public void closeConnection(){
        try{
            getConnection().close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String []argas){
        getConnection();
    }
}
