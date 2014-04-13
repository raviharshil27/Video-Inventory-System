package videostore;

import java.io.*;
import java.nio.channels.FileChannel;
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
        File sourceFile = new File(filePath + File.separator +  "Memento.data");
        File destinationFile = new File(filePath + File.separator +  "Memento.data.old");
        FileOutputStream fileOut = null;
        ObjectOutputStream out =null;
        Memento memento = mementoList.get(mementoList.size()-1);
        try {
            copyFile(sourceFile, destinationFile);
            fileOut =new FileOutputStream(filePath + File.separator + "Memento.data");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(memento);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            copyFile(destinationFile,sourceFile);
            
            Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally
        {
            destinationFile.delete();
        }
        File commandFile = new File(filePath+File.separator + "command.data");
        commandFile.delete();
        return true;
    }
   
   private void copyFile(File sourceFile, File destFile)
   {
       if(sourceFile.exists() && destFile.exists())
       {
        try {
            FileChannel source = new FileInputStream(sourceFile).getChannel();
            FileChannel destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CareTaker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CareTaker.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
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
