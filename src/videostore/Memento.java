package videostore;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harshil
 */
public class Memento{
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
