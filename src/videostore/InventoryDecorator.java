package videostore;

import com.command.*;
import com.command.addMovie;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harshil
 */
public class InventoryDecorator extends AbstractInventoryDecorator {

        private static int commandCounter=0;
        private CareTaker careTaker = new CareTaker();
    public static void main(String args[]) {
        InventoryDecorator decorator = new InventoryDecorator();
//        decorator.addNewMovie("ironman1", 22, 2);
//        decorator.addNewMovie("ironman2", 22, 2);
//        decorator.addNewMovie("ironman3", 22, 2);
//        decorator.careTaker.add(decorator.saveInventoryToMemento());
//        decorator.careTaker.write("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data");
       
//        decorator.addNewMovie("ironman4", 22, 2);
//        decorator.addNewMovie("ironman5", 22, 2);
//        decorator.addNewMovie("ironman6", 22, 2);
        
        System.out.println(decorator);
    }

    public InventoryDecorator() {
        inventory = new Inventory();
        restoreInventory();
    }

    private void restoreInventory() {

        File commandFile = new File("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data\\command.data");
        if (commandFile.exists()) {
            restoreMemento("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data");
//            inventory = new Inventory();
            executeCommands();
            System.out.println("Commands Restored From the file... and file removed...");
        }
    }

    private void restoreMemento(String inputFile)
    {
//        CareTaker careTaker = new CareTaker();
        File mementoFile = new File(inputFile + File.separator + "Memento.data");
        if(mementoFile.exists())
        {
        Memento memento = careTaker.read(inputFile);
        inventory = memento.getInventory();
        }
        else
            inventory = new Inventory();
    }
        
    public void executeCommands() {
        FileInputStream fileRead = null;
        ObjectInputStream input = null;
        String filePath = "C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data";
        Command command;
        try {
            fileRead = new FileInputStream(filePath + File.separator + "command.data");
            input = new ObjectInputStream(fileRead);
            while ((command = (Command) input.readObject()) != null) {

//            command= (Command) input.readObject();
//            command= (Command) input.readObject();
                command.execute(inventory);

            }

        } catch (EOFException ex) {
//            Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("End of command file with eofexception...Command Read successfully.....");
            //return false;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(InventoryDecorator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
                fileRead.close();
            } catch (IOException ex) {
                Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        File commandFile = new File(filePath+File.separator + "command.data");
        commandFile.deleteOnExit();
          careTaker.add(saveInventoryToMemento());
          careTaker.write("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data");
//                
    }

    public Memento saveInventoryToMemento()
    {
      return new Memento(inventory);
    }
    
    private void checkCommandCounter()
    {
        commandCounter++;
        if(commandCounter==3)
        {
           careTaker.add(saveInventoryToMemento());
           careTaker.write("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data");
           commandCounter=0;
        }
    }
    
    @Override
    public void addNewMovie(String movieName, float price, int quantity) {
        Command command = new addMovie(movieName, price, quantity);
        command.execute(inventory);
        checkCommandCounter();
    }

    @Override
    public void sell(String movieName, int quantity) {
        Command command = new sellMovie(movieName, quantity);
        command.execute(inventory);
        checkCommandCounter();
    }

    @Override
    public void updateQuantity(String movieName, int quantity) {
        Command command = new updateQuantity(movieName, quantity);
        command.execute(inventory);
        checkCommandCounter();
    }

    @Override
    public void updatePrice(String movieName, float price) {
        Command command = new updatePrice(movieName, price);
        command.execute(inventory);
        checkCommandCounter();        
       
    }
}
