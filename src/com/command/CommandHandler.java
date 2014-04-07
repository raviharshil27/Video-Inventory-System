/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import videostore.Memento;

/**
 *
 * @author Harshil
 */
public class CommandHandler {
    List<Command> commandList = new ArrayList<>();
    
    public Memento read(String filePath)
    {
        FileInputStream fileRead = null;
        ObjectInputStream input =null;
        Memento memento = null;
        try {
            fileRead =new FileInputStream(filePath+ File.separator + "command.data");
            input = new ObjectInputStream(fileRead);
            comm= () input.readObject();
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
