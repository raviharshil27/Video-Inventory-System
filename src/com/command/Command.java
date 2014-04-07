/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.command;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import videostore.AbstractInventory;
import videostore.CareTaker;
import videostore.Inventory;
import videostore.Memento;

/**
 *
 * @author Harshil
 */
public abstract class Command implements Serializable{
    public abstract void execute(AbstractInventory inventory);
//    public abstract boolean write(String file);
    public boolean write(String filePath) {
        FileOutputStream fileOut = null;
        ObjectOutputStream out =null;
        
        try {
            fileOut =new FileOutputStream(filePath + File.separator + "command.data", true);
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
