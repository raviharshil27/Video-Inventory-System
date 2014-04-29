package videostore;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Harshil
 */
public class NoHeaderObjectOutputStream extends ObjectOutputStream {

    public NoHeaderObjectOutputStream(OutputStream os) throws IOException {
        super(os);
    }

    @Override
    protected void writeStreamHeader() {
    }

}
