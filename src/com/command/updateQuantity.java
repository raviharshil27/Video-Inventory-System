/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.command;

import videostore.AbstractInventory;
import videostore.Inventory;

/**
 *
 * @author Harshil
 */
public class updateQuantity extends Command{

    private String movieName;
    private int quantity;
    
    public updateQuantity(String movieName, int quantity) {
        this.movieName= movieName;
        this.quantity = quantity;
        write("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data");
    }

    
    @Override
    public void execute(AbstractInventory inventory) {
        inventory.updateQuantity(movieName, quantity);
    }
    
}
