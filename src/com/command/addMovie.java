/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.command;

import videostore.AbstractInventory;

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
    public void execute(AbstractInventory inventory) {
        inventory.addNewMovie(name, price, quantity);
    }
    
}
