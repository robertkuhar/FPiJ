package ch03;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WatchFileChange {
    public static void main( String[] args ) {
        System.out.println( "begin" );
        new Thread( ( ) -> watchFileChange() ).start();
        final File file = new File( "sample.txt" );
        try {
            file.createNewFile();
            Thread.sleep( 2000 );
            System.out.println( file.getName() + " lastModified " + new Date( file.lastModified() ) );
            file.setLastModified( System.currentTimeMillis() );
            System.out.println( file.getName() + " lastModified " + new Date( file.lastModified() ) );
            Thread.sleep( 2000 );
        } catch ( IOException e ) {
            e.printStackTrace();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println( "end" );
    }

    public static void watchFileChange() {
        try {
            // We're not watching the file, we're watching the directory
            final Path path = Paths.get( "." );
            final WatchService watchService = path.getFileSystem().newWatchService();
            path.register( watchService, StandardWatchEventKinds.ENTRY_MODIFY );

            System.out.println( "Report any file changed within next 1 minute..." );

            final WatchKey watchKey = watchService.poll( 1, TimeUnit.MINUTES );

            if ( watchKey != null ) {
                watchKey.pollEvents().stream().forEach( event -> {
                    System.out.println( event.context() );
                } );
            }
        } catch ( InterruptedException | IOException ex ) {
            System.out.println( ex );
        }
    }

}
