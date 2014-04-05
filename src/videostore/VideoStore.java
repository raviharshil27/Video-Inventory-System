/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videostore;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Harshil
 */
public class VideoStore {

    
    
    
    public static void main(String[] args) {
        
//         CareTaker careTaker= new CareTaker();
//        Memento m = careTaker.read("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore");
//        m.getInventory().getId("ironman2");
        
       
        Inventory inventory = new  Inventory();
        inventory.addNewMovie("ironman1", 22, 2);
        inventory.addNewMovie("ironman2", 22, 2);
        
        inventory.addNewMovie("ironman3", 22, 2);
        
        Originator originator = new Originator();
        originator.setInventory(inventory);
        
        CareTaker careTaker= new CareTaker();
        careTaker.add(originator.saveInventoryToMemento());
        careTaker.write("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data");
        Memento m = careTaker.read("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data");
        m.getInventory().getId("ironman2");
        inventory.sell("ironman2", 2);
        System.out.println(inventory.getId("ironman2") +"--"+ inventory.getQuantity("ironman2"));
        System.out.print(inventory.getQuantity(0));
       
    }
}
