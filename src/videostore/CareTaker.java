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
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();
    
    public void add(Memento state){
      mementoList.add(state);
   }

   public Memento get(int index){
      return mementoList.get(index);
   }
    
}
