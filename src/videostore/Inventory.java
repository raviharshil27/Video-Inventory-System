/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videostore;

import com.command.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harshil
 */
public class Inventory  implements Serializable{
//    private List<Movie> movieInventory = new ArrayList<>();
    private HashMap<Integer,Movie> idToMovie = new HashMap<>();
    private HashMap<String,Movie> nameToMovie = new HashMap<>();
    
    
   
    public static void main(String args[])
    {
        Inventory inbentory = new  Inventory();
        inbentory.addNewMovie("asd", 22, 2);
        inbentory.sell("asd", 2);
        System.out.println(inbentory.getId("asd") +"--"+ inbentory.getQuantity("asd"));
        System.out.print(inbentory.getQuantity(0));
                
    }
    
    public void addNewMovie(String movieName,float price,int quantity)
    {
        Movie movie = new Movie(movieName, price, quantity);
        idToMovie.put(movie.movieId, movie);
        nameToMovie.put(movieName, movie);
        Command command = new addMovie(movieName, price, quantity);
        System.out.println();
    }
    
    public void sell(String movieName,int quantity)
    {
        Movie movie = nameToMovie.get(movieName);
        movie.decreaseQuantity(2);
        Command command = new sellMovie(movieName, quantity);
    }
    
    public void updateQuantity(String movieName,int quantity)
    {
        Movie movie = nameToMovie.get(movieName);
        movie.increaseQuantity(2);   
        Command command = new updateQuantity(movieName, quantity);

    }
    
    public void updatePrice(String movieName, float price)
    {
       Movie movie = nameToMovie.get(movieName);
       movie.updatePrice(price);
       Command command = new updatePrice(movieName, price);
    }
    
    public float getPrice(String movieName)
    {
        float price =0;
        return price;
    }
    
    public float getPrice(int movieId)
    {
        float price =0;
        return price;
    }
    
    public int getQuantity(String movieName)
    {
        int quantity=0;
        return quantity;
    }
    
    public int getQuantity(int movieId)
    {
        int quantity=0;
        return quantity;
    }

// Testing purpose.... Removce it later on....    
    public int getId(String movieName)
    {
        Movie movie=nameToMovie.get(movieName);
        return movie.movieId;
                
    }
}
