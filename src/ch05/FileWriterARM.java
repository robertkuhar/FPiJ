/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch05;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.AutoCloseable;

public class FileWriterARM implements AutoCloseable {
    private final FileWriter writer;

    public FileWriterARM( final String fileName ) throws IOException {
        writer = new FileWriter( fileName );
    }

    public void writeStuff( final String message ) throws IOException {
        writer.write( message );
    }

    public void close() throws IOException {
        System.out.println( "close called automatically..." );
        writer.close();
    }

    // ...

    public static void main( final String[] args ) throws IOException {
        try ( final FileWriterARM writerARM = new FileWriterARM( "work/peekaboo.txt" ) ) {
            writerARM.writeStuff( "peek-a-boo" );

            System.out.println( "done with the resource..." );
        }
    }

}
