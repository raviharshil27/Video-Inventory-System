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

    public static void main(String args[]) {
        InventoryDecorator decorator = new InventoryDecorator();
//        decorator.addNewMovie("ironman1", 22, 2);
//        decorator.addNewMovie("ironman2", 22, 2);
//        decorator.addNewMovie("ironman3", 22, 2);
        System.out.println(decorator);
    }

    public InventoryDecorator() {
        inventory = new Inventory();
        restoreInventory();
    }

    public void restoreInventory() {

        File commandFile = new File("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data");
        if (commandFile.exists()) {
            CareTaker careTaker = new CareTaker();
            Memento memento = careTaker.read("C:\\Users\\Harshil.Harshil-PC\\Documents\\NetBeansProjects\\VideoStore\\data");
            inventory = memento.getInventory();
            inventory = new Inventory();
            executeCommands();

            System.out.println("Commands Restored From the file... and file removed...");
        }
//        else
//        {
//            
//        }
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
//            System.out.println("Command Read successfully.....");
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
//        File commandFile = new File(filePath+File.separator + "command.data");
//        commandFile.deleteOnExit();
    }

    @Override
    public void addNewMovie(String movieName, float price, int quantity) {
        Command command = new addMovie(movieName, price, quantity);
        command.execute(inventory);
    }

    @Override
    public void sell(String movieName, int quantity) {
        Command command = new sellMovie(movieName, quantity);
        command.execute(inventory);

    }

    @Override
    public void updateQuantity(String movieName, int quantity) {
        Command command = new updateQuantity(movieName, quantity);
        command.execute(inventory);
    }

    @Override
    public void updatePrice(String movieName, float price) {
        Command command = new updatePrice(movieName, price);
        command.execute(inventory);
    }

    @Override
    public float getPrice(String movieName) {
        return inventory.getPrice(movieName);
    }

    @Override
    public float getPrice(int movieId) {
        return inventory.getPrice(movieId);
    }

    @Override
    public int getQuantity(String movieName) {
        return inventory.getQuantity(movieName);
    }

    @Override
    public int getQuantity(int movieId) {
        return inventory.getQuantity(movieId);
    }

}
