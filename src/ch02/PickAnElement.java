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

import java.util.List;
import java.util.Optional;

public class PickAnElement {
    public static void uglyPickName( final List<String> names, final String startingLetter ) {
        String foundName = null;
        for ( String name : names ) {
            if ( name.startsWith( startingLetter ) ) {
                foundName = name;
                break;
            }
        }
        System.out.print( String.format( "A name starting with %s: ", startingLetter ) );

        if ( foundName != null ) {
            System.out.println( foundName );
        } else {
            System.out.println( "No name found" );
        }
    }

    public static void functionalPickName( final List<String> names, final String startingLetter ) {
        // BobK. Hmmm. We have to walk the whole collection and then
        // .findFirst()!? P35 says "NO!"
        final Optional<String> foundName = names.stream()
                .filter( name -> name.startsWith( startingLetter ) )
                .findFirst();
        System.out.println( String.format( "A name starting with %s: %s", startingLetter, foundName.orElse( "No name found" ) ) );
        foundName.ifPresent( name -> System.out.println( "Hello " + name ) );
    }

    public static void main( final String[] args ) {
        uglyPickName( friends, "N" );
        uglyPickName( friends, "Z" );

        functionalPickName( friends, "N" );
        functionalPickName( friends, "Z" );
    }

}
