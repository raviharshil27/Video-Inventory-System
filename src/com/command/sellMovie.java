/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.command;

import videostore.Inventory;

/**
 *
 * @author Harshil
 */
public class sellMovie extends Command{

    private String movieName;
    private int quantity;
    public sellMovie(String movieName, int quantity) {
        this.movieName= movieName;
        this.quantity = quantity;
    }

    @Override
    public void execute(Inventory inventory) {
        inventory.sell(movieName, quantity);
    }

   
    
}
