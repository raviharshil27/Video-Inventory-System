/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videostore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harshil
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();
    
    public void add(Memento state){
      
      mementoList.add(state.clone());
   }

   public Memento get(int index){
      return mementoList.get(index);
   }
   
   public boolean write(String filePath)
    {
        FileOutputStream fileOut = null;
        ObjectOutputStream out =null;
        Memento memento = mementoList.get(mementoList.size()-1);
        try {
            fileOut =new FileOutputStream(filePath + File.separator + "Memento.data");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(memento);
            
        } catch (IOException ex) {
            Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            try {
                out.close();
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(CareTaker.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return true;
    }
   
   public Memento read(String filePath)
    {
        FileInputStream fileRead = null;
        ObjectInputStream input =null;
        Memento memento = null;
        try {
            fileRead =new FileInputStream(filePath+ File.separator + "Memento.data");
            input = new ObjectInputStream(fileRead);
            memento= (Memento) input.readObject();
            add(memento);
        } catch (Exception ex) {
            Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            //return false;
        }
        finally
        {
            try {
                input.close();
                fileRead.close();
            } catch (IOException ex) {
                Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return memento;
    }
    
}
