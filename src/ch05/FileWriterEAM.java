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

public class FileWriterEAM {
    private final FileWriter writer;

    private FileWriterEAM( final String fileName ) throws IOException {
        writer = new FileWriter( fileName );
    }

    private void close() throws IOException {
        System.out.println( "close called automatically..." );
        writer.close();
    }

    public void writeStuff( final String message ) throws IOException {
        writer.write( message );
    }

    // ...

    public static void use( final String fileName, final UseInstance<FileWriterEAM, IOException> block ) throws IOException {
        final FileWriterEAM writerEAM = new FileWriterEAM( fileName );
        try {
            block.accept( writerEAM );
        } finally {
            writerEAM.close();
        }
    }

    public static void main( final String[] args ) throws IOException {

        System.out.println( "//" + "START:EAM_USE_OUTPUT" );
        FileWriterEAM.use( "work/eam.txt", writerEAM -> writerEAM.writeStuff( "sweet" ) );
        System.out.println( "//" + "END:EAM_USE_OUTPUT" );

        FileWriterEAM.use( "work/eam2.txt", writerEAM -> {
            writerEAM.writeStuff( "how\n" );
            writerEAM.writeStuff( "sweet\n" );
        } );

    }

}
