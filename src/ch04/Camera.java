/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch04;

import java.awt.Color;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Camera {
    // BobK: This
    // "earlier argument is the input value the later is the return value" is
    // going to take some getting used to
    private Function<Color, Color> filter;

    public Camera() {
        setFilters();
    }

    @SafeVarargs
    public final void setFilters( final Function<Color, Color>... filters ) {
        filter = Stream.of( filters ).reduce( ( filter, next ) -> filter.compose( next ) ).orElse( color -> color );
    }

    public Color capture( final Color inputColor ) {
        // More processing of color...
        final Color processedColor = filter.apply( inputColor );
        return processedColor;
    }

    public static void main( final String[] args ) {
        final Camera camera = new Camera();
        final Consumer<String> printCaptured = ( filterInfo ) -> System.out.println( String.format(
                "with %s: %s",
                filterInfo,
                camera.capture( new Color( 200, 100, 200 ) ) ) );

        printCaptured.accept( "no filter" );

        camera.setFilters( Color::brighter );
        printCaptured.accept( "brighter filter" );

        camera.setFilters( Color::darker );
        printCaptured.accept( "darker filter" );

        camera.setFilters( Color::brighter, Color::darker );
        printCaptured.accept( "brighter & darker filter" );
    }

}