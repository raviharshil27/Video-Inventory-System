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
public class updatePrice extends Command{
    private String movieName;
    private float price;
    
    public updatePrice(String movieName, float price) {
        this.movieName= movieName;
        this.price = price;
    }

    
    @Override
    public void execute(AbstractInventory inventory) {
        inventory.updatePrice(movieName, price);
    }
    
    
}
