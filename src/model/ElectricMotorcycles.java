/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author JUAN PABLO
 */
public class ElectricMotorcycles {
    private String producerName;
    private int price;
    private int id;
    private int autonomy;
    private int supplier;
    
    public ElectricMotorcycles(int id, String producerName, int price, int autonomy, int supplier){
        this.producerName = producerName;
        this.price = price;
        this.id = id;
        this.autonomy = autonomy;
        this.supplier = supplier;
    }
    
    public ElectricMotorcycles(String producerName, int price){
        this.producerName = producerName;
        this.price = price;
    }
    
    public String getProducerName(){
        return this.producerName;
    }
    
    public int getPrice(){
        return this.price;
    }

    public int getId() {
        return id;
    }

    public int getAutonomy() {
        return autonomy;
    }

    public int getSupplier() {
        return supplier;
    }
  
    @Override
    public String toString(){
        return "Fabricante: " + this.producerName +  "\nPrecio: " + this.price + "\n";
    }
}
