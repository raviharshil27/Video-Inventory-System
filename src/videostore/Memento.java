package videostore;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harshil
 */
public class Memento implements Serializable{
    private AbstractInventory inventory;
    
    public Memento (AbstractInventory inventory)
    {
        this.inventory = inventory;
    }
    
    public AbstractInventory getInventory()
    {
        return inventory;
    }
    
     @Override
    public Memento clone()
    {
        Inventory clonnedInventory = new Inventory();
         ObjectInputStream ois = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            //Serialize it
            ObjectOutputStream o = new ObjectOutputStream(bos);
            o.writeObject(inventory);
//            /serializeToOutputStream(inventory, bos);
            byte[] bytes = bos.toByteArray();
            ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
//            Deserialize it and return the new instance
            //return clonnedInventory;
            clonnedInventory = (Inventory) ois.readObject();
        } catch (Exception ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           return new Memento(clonnedInventory);

    }
    
    
}
