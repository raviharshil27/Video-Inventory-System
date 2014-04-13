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
public class InventoryDecoratorTest {
    
    private InventoryDecorator decorator ;
    public InventoryDecoratorTest() {
        
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
    }
    
    @After
    public void tearDown() {
    }

   
     @Test
     public void inventoryTest() {
        decorator.addNewMovie("ironman1", (float) 2.23, 2);
        decorator.addNewMovie("ironman2", 22, 2);
        decorator.addNewMovie("ironman3", 22, 2);
        System.out.println("---------"+decorator.getPrice("ironman1"));
        assertEquals((float) 2.23, decorator.getPrice("ironman1") ,0.001);
        System.out.println(decorator);
     }
//Focrefully cerating the memenot and command file to make it look like system crash...     
     private void createBackUpFiles()
     {
         File commandFile= new File("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data\\command.data");
         File mementoFile= new File("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data\\Memento.data");
         if(mementoFile.exists())
            mementoFile.delete();
         if(commandFile.exists())
            commandFile.delete();
        decorator = new InventoryDecorator();

        decorator.addNewMovie("ironman1", (float) 2.23, 2);
        decorator.addNewMovie("ironman2", 22, 2);
        decorator.addNewMovie("ironman3", 22, 2);
        
        decorator.updatePrice("ironman3", 10);
     }
     
     @Test
     public void inventoryRestoreTest()
     {
         
         createBackUpFiles();
         decorator= new InventoryDecorator();
         assertEquals(10, decorator.getPrice("ironman3"),0.001);
//         System.out.println("---" + decorator.getPrice("ironman3"));
         decorator.updatePrice("ironman1", 100);
        //assume system is crashed and new invenrotyDecorator is created....
         decorator= new InventoryDecorator();
         assertEquals(100, decorator.getPrice("ironman1"),0.0001);

//         System.out.println("---" + decorator.getPrice("ironman1"));
     }
}
