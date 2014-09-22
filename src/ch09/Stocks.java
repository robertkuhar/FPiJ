/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch09;

import java.util.Arrays;
import java.util.List;

public class Stocks {
    public static void main( String[] args ) {
        List<Integer> prices = Arrays.asList( 10, 20, 30, 40, 50, 60 );

        {
            int max = 0;
            for ( int price : prices ) {
                if ( max < price ) {
                    max = price;
                }
            }

            System.out.println( max );
        }

        final int max = prices.stream()
                .reduce( 0, Math::max );
        System.out.println( max );
    }
}
