/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videostore;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Harshil
 */
public class NoHeaderObjectOutputStream extends ObjectOutputStream{
    public NoHeaderObjectOutputStream(OutputStream os) throws IOException {
		super(os);
	}

    @Override
	protected void writeStreamHeader() {
	}
    
}
