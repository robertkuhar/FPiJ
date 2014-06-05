package ch03;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListFiles {

    public static void main( String[] args ) {
        try {
            listFiles();
            listSelectFiles();
            listHiddenFiles();
            listImmediateSubDirs();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    private static void listFiles() throws IOException {
        System.out.println( "all files" );
        Files.list( Paths.get( "." ) ).forEach( System.out::println );

        System.out.println( "only directories" );
        Files.list( Paths.get( "." ) ).filter( Files::isDirectory ).forEach( System.out::println );

        System.out.println( "only directories" );
        Files.list( Paths.get( "." ) ).filter( f -> f.toFile().isDirectory() ).forEach( System.out::println );
    }

    private static void listSelectFiles() throws IOException {
        final String[] oldSchoolFiles = new File( "./src/ch03" ).list( new java.io.FilenameFilter() {
            @Override
            public boolean accept( File dir, String name ) {
                return name.endsWith( ".java" );
            }
        } );
        System.out.println( "oldSchoolFiles " + Arrays.toString( oldSchoolFiles ) );

        // What?! No collect() method on DirectoryStream?
        Files.newDirectoryStream( Paths.get( "./src/ch03" ), path -> path.toString().endsWith( ".java" ) ).forEach(
                System.out::println );
    }

    private static void listHiddenFiles() throws IOException {
        final File[] files = new File( "." ).listFiles( file -> file.isHidden() );
        System.out.println( "oldSchoolFiles " + Arrays.toString( files ) );
    }

    private static void listImmediateSubDirs() {
        theHardWay();
        theFlatMapWay();
    }

    private static void theFlatMapWay() {
        List<File> files = Stream.of( new File( "." ).listFiles() )
                .flatMap( file -> file.listFiles() == null ? Stream.of( file ) : Stream.of( file.listFiles() ) )
                .collect( Collectors.toList() );
        System.out.println( "theFlatMapWay():  Count: " + files.size() );
    }

    /**
     * List all the files in current directory and one-level-down subdirs.
     */
    private static void theHardWay() {
        List<File> files = new ArrayList<>();
        File[] filesInCurrentDir = new File( "." ).listFiles();
        for ( File file : filesInCurrentDir ) {
            File[] filesInSubDir = file.listFiles();
            if ( filesInSubDir != null ) {
                files.addAll( Arrays.asList( filesInSubDir ) );
            } else {
                files.add( file );
            }
        }
        System.out.println( "theHardWay():  Count: " + files.size() );
    }

}
