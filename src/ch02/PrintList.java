/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch02;

import static ch02.Folks.friends;
import static java.util.stream.Collectors.joining;

public class PrintList {
    public static void main( final String[] args ) {
        // Dangling comma sucks...
        System.out.println( "//" + "START:FOREACH_OUTPUT" );
        for ( String name : friends ) {
            System.out.print( name + ", " );
        }
        System.out.println();
        System.out.println( "//" + "END:FOREACH_OUTPUT" );

        // Avoiding the dangling comma sucks too...
        System.out.println( "//" + "START:FOR_OUTPUT" );
        for ( int i = 0; i < friends.size() - 1; i++ ) {
            System.out.print( friends.get( i ) + ", " );
        }
        if ( friends.size() > 0 ) {
            System.out.println( friends.get( friends.size() - 1 ) );
        }
        System.out.println( "//" + "END:FOR_OUTPUT" );

        // Ahhh. That looks better...
        System.out.println( "//" + "START:JOIN_OUTPUT" );
        System.out.println( String.join( ", ", friends ) );
        System.out.println( "//" + "END:JOIN_OUTPUT" );

        System.out.println( "//" + "START:MAP_JOIN_OUTPUT" );
        System.out.println( friends.stream()
                .map( String::toUpperCase )
                .collect( joining( ", " ) ) );
        System.out.println( "//" + "END:MAP_JOIN_OUTPUT" );

    }

}
