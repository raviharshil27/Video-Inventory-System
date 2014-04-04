/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videostore;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harshil
 */
public class Originator {
    private Inventory inventory;
    
    public void setInventory(Inventory inventory)
    {
        this.inventory=inventory;
    }
    
    public Inventory getInventory()
    {
        return inventory;
    }
    
    public Memento saveInventoryToMemento(){
      return new Memento(inventory);
   }

   public void getInventoryFromMemento(Memento Memento){
      inventory = Memento.getInventory();
   }
   
   public boolean write(String filePath)
    {
        FileOutputStream fileOut = null;
        ObjectOutputStream out =null;
        try {
            fileOut =new FileOutputStream(filePath);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(inventory);
            
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
                Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



        return true;
        
    }
   
                   
         
    
}
