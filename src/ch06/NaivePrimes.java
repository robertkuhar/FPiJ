/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch06;

import static ch06.PrimeFinder.isPrime;

import java.util.ArrayList;
import java.util.List;

public class NaivePrimes {
    public static List<Integer> concat( final int number, final List<Integer> numbers ) {
        final List<Integer> values = new ArrayList<>();
        values.add( number );
        values.addAll( numbers );
        return values;
    }

    // don't try this at the office
    public static List<Integer> primes( final int number ) {
        if ( isPrime( number ) ) {
            return concat( number, primes( number + 1 ) );
        } else {
            return primes( number + 1 );
        }
    }

    public static void main( final String[] args ) {
        try {
            primes( 1 );
        } catch ( StackOverflowError ex ) {
            System.out.println( ex );
        }
    }
}
