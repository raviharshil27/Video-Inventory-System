package com.test;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import videostore.InventoryDecorator;

/**
 *
 * @author Harshil
 */
public class CommandTest {
    private InventoryDecorator decorator ;

    public CommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        decorator = new InventoryDecorator();
        System.out.println("BNew Inventory created...");
        decorator.addNewMovie("ironman1", (float) 2.23, 2);
        decorator.addNewMovie("ironman2", 22, 2);
        decorator.addNewMovie("ironman3", 22, 2);
    }
    
    @After
    public void tearDown() {
        System.out.println("Teardown called....");
        File commandFile= new File("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data\\command.data");
         File mementoFile= new File("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data\\Memento.data");
         if(mementoFile.exists())
            mementoFile.delete();
         if(commandFile.exists())
            commandFile.delete();
    }

    @Test
     public void sellCommand() {
        decorator.sell("ironman1", 2);
        assertEquals(0, decorator.getQuantity("ironman1"));
     }
     
     @Test
     public void changePriceCommand()
     {
         decorator.updatePrice("ironman1", (float) 0.02);
         assertEquals(0.02, decorator.getPrice("ironman1"),0.0001);
     }
     
     @Test
     public void updateQuantityCommand()
     {
         System.out.println("------------"+ decorator.getQuantity("ironman1"));
         decorator.increaseQuantity("ironman1", 50);
        assertEquals(52, decorator.getQuantity("ironman1"));

     }
}
