/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch02;

import java.util.function.Consumer;
import static ch02.Folks.friends;

public class Iteration {
    public static void main( final String[] args ) {
        // self-inflicted wound pattern...
        System.out.print( "for i gets 0...." );
        for ( int i = 0; i < friends.size(); i++ ) {
            System.out.print( " " + friends.get( i ) );
        }

        System.out.print( "\nfor x in y...." );
        for ( String name : friends ) {
            System.out.print( " " + name );
        }

        System.out.print( "\nIterable.forEach old-school anonymous inner class..." );
        friends.forEach( new Consumer<String>() {
            public void accept( final String name ) {
                System.out.print( " " + name );
            }
        } );

        System.out.print( "\nIterable.forEach full lambda expression..." );
        friends.forEach( ( final String name ) -> System.out.print( " " + name ) );

        System.out.print( "\nIterable.forEach lambda expression, type inference..." );
        friends.forEach( ( name ) -> System.out.print( " " + name ) );

        System.out.print( "\nIterable.forEach lambda expression, type inference on single parameter..." );
        friends.forEach( name -> System.out.print( " " + name ) );

        System.out.print( "\nIterable.forEach method-reference..." );
        friends.forEach( System.out::print );
    }
}
