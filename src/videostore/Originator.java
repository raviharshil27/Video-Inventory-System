/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videostore;
/**
 *
 * @author Harshil
 */
public class Originator {
    private AbstractInventory inventory;
    
    
    public void setInventory(Inventory inventory)
    {
        this.inventory=inventory;
    }
    
    public AbstractInventory getInventory()
    {
        return inventory;
    }
    
    public Memento saveInventoryToMemento(){
      return new Memento(inventory);
   }

   public void getInventoryFromMemento(Memento Memento){
      inventory = Memento.getInventory();
   }
}
