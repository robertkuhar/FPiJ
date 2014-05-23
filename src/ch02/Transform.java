/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch02;

import java.util.List;
import java.util.ArrayList;
import static ch02.Folks.friends;

public class Transform {
    public static void main( final String[] args ) {
        {
            // self-inflicted wound pattern...
            final List<String> uppercaseNames = new ArrayList<String>();
            for ( String name : friends ) {
                uppercaseNames.add( name.toUpperCase() );
            }
            System.out.println( "for x in y...." + uppercaseNames );
        }
        {
            final List<String> uppercaseNames = new ArrayList<String>();
            friends.forEach( name -> uppercaseNames.add( name.toUpperCase() ) );
            System.out.println( "Iterable.forEach lambda expression, type inference..." + uppercaseNames );
        }

        System.out.print( "Stream.map over Iterable.forEach..." );
        friends.stream().map( name -> name.toUpperCase() ).forEach( name -> System.out.print( name + " " ) );

        System.out.print( "\nStream.map over Iterable.forEach, different type..." );
        friends.stream().map( name -> name.length() )
                .forEach( count -> System.out.print( count.getClass().getSimpleName() + "( " + count + " ) " ) );

        System.out.print( "\nStream.map with Method Reference over Iterable.forEach..." );
        friends.stream().map( String::toUpperCase ).forEach( name -> System.out.print( name + " " ) );
    }

}
