/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.command;

import java.io.Serializable;
import videostore.Inventory;

/**
 *
 * @author Harshil
 */
public abstract class Command implements Serializable{
    public abstract void execute(Inventory inventory);
    public abstract boolean write(String file);
    
}
