/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.command;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import videostore.CareTaker;
import videostore.Inventory;
import videostore.Memento;

/**
 *
 * @author Harshil
 */
public class addMovie extends Command{
    private String name;
    private float price;
    private int quantity;
    public addMovie(String name,float price,int quantity)
    {
        this.name= name;
        this.price = price;
        this.quantity = quantity;
        write("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data");
    }
    @Override
    public void execute(Inventory inventory) {
        inventory.addNewMovie(name, price, quantity);
    }

    
    @Override
    public boolean write(String filePath) {
        FileOutputStream fileOut = null;
        ObjectOutputStream out =null;
        
        try {
            fileOut =new FileOutputStream(filePath + File.separator + "command.data");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            
        } catch (IOException ex) {
            Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            try {
                out.close();
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(CareTaker.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return true;
       
    }
    
    
}