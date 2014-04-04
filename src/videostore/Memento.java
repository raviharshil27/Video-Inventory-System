/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videostore;

/**
 *
 * @author Harshil
 */
public class Memento {
    private Inventory inventory;
    
    public Memento (Inventory inventory)
    {
        this.inventory = inventory;
    }
    
    public Inventory getInventory()
    {
        return inventory;
    }
}
