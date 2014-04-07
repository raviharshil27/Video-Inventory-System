/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videostore;

/**
 *
 * @author Harshil
 */
public abstract class AbstractInventory {
    public abstract void addNewMovie(String movieName, float price, int quantity);

    public abstract void sell(String movieName, int quantity);

    public abstract void updateQuantity(String movieName, int quantity);

    public abstract void updatePrice(String movieName, float price);

    public abstract float getPrice(String movieName);

    public abstract float getPrice(int movieId);

    public abstract int getQuantity(String movieName);

    public abstract int getQuantity(int movieId);
    
}
