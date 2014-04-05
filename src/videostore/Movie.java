
package videostore;

import java.io.Serializable;

/**
 *
 * @author Harshil
 */
public class Movie implements Serializable{
    
    protected String name;
    private static int uniqueCounter=0;
    protected int movieId;
    protected float price;
    protected int quantity=0;
    
    public Movie(String name,float price)
    {
        this.name = name;
        this.price = price;
        movieId = uniqueCounter;
        uniqueCounter++;
    }
    
    public Movie(String name,float price,int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        movieId = uniqueCounter;
        uniqueCounter++;
    }
    
    public void decreaseQuantity(int count)
    {
        quantity -= count;
    }
    
    public void increaseQuantity(int count)
    {
        quantity += count;
    }
    
    public void updatePrice(float price)
    {
        this.price = price;
    }
    
    
}
