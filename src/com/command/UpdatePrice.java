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
public class UpdatePrice extends Command{
    private String movieName;
    private float price;
    
    public UpdatePrice(String movieName, float price) {
        this.movieName= movieName;
        this.price = price;
        write("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data");
    }

    
    @Override
    public void execute(AbstractInventory inventory) {
        inventory.updatePrice(movieName, price);
    }
    
    
}
