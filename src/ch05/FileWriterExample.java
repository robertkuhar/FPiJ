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

public class FileWriterExample {
    private final FileWriter writer;

    public FileWriterExample( final String fileName ) throws IOException {
        writer = new FileWriter( fileName );
    }

    public void writeStuff( final String message ) throws IOException {
        writer.write( message );
    }

    public void finalize() throws IOException {
        writer.close();
    }

    // ...

    public void close() throws IOException {
        writer.close();
    }

    /*
     * public static void main(final String[] args) throws IOException { final
     * FileWriterExample writerExample = new FileWriterExample("peekaboo.txt");
     * writerExample.writeStuff("peek-a-boo"); }
     */

    public static void callClose( final String[] args ) throws IOException {
        final FileWriterExample writerExample = new FileWriterExample( "work/peekaboo.txt" );

        writerExample.writeStuff( "peek-a-boo" );
        writerExample.close();
    }

    public static void main( final String[] args ) throws IOException {
        final FileWriterExample writerExample = new FileWriterExample( "work/peekaboo.txt" );
        try {
            writerExample.writeStuff( "peek-a-boo" );
        } finally {
            writerExample.close();
        }
    }

}
