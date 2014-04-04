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
        Inventory inventory = new  Inventory();
        inventory.addNewMovie("ironman1", 22, 2);
        inventory.addNewMovie("ironman2", 22, 2);
        inventory.addNewMovie("ironman3", 22, 2);
        
        
        inventory.sell("asd", 2);
        System.out.println(inventory.getId("asd") +"--"+ inventory.getQuantity("asd"));
        System.out.print(inventory.getQuantity(0));
        
    }
}
