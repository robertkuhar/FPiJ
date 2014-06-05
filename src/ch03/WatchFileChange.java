package ch03;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

public class WatchFileChange {
    public static void main( String[] args ) {
        new Thread( ( ) -> watchFileChange() ).start();
        final File file = new File( "sample.txt" );
        try {
            file.createNewFile();
            Thread.sleep( 5000 );
            file.setLastModified( System.currentTimeMillis() );
        } catch ( IOException e ) {
            e.printStackTrace();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

    public static void watchFileChange() {
        try {
            final Path path = Paths.get( "." );
            final WatchService watchService = path.getFileSystem().newWatchService();

            path.register( watchService, StandardWatchEventKinds.ENTRY_MODIFY );

            System.out.println( "Report any file changed within next 1 minute..." );

            final WatchKey watchKey = watchService.poll( 1, TimeUnit.MINUTES );

            if ( watchKey != null ) {
                watchKey.pollEvents().stream().forEach( event -> System.out.println( event.context() ) );
            }
        } catch ( InterruptedException | IOException ex ) {
            System.out.println( ex );
        }
    }

}
