/***
 * Excerpted from "Functional Programming in Java", published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch01;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Discounter {
    public BigDecimal imperativeDiscounter( List<BigDecimal> prices ) {
        BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
        for ( BigDecimal price : prices ) {
            if ( price.compareTo( BigDecimal.valueOf( 20 ) ) > 0 ) {
                totalOfDiscountedPrices = totalOfDiscountedPrices.add( price.multiply( BigDecimal.valueOf( 0.9 ) ) );
            }
        }
        return totalOfDiscountedPrices;
    }

    public BigDecimal functionalDiscounter( List<BigDecimal> prices ) {
        final BigDecimal totalOfDiscountedPrices = prices.stream()
                .filter( price -> price.compareTo( BigDecimal.valueOf( 20 ) ) > 0 )
                .map( price -> price.multiply( BigDecimal.valueOf( 0.9 ) ) )
                .reduce( BigDecimal.ZERO, BigDecimal::add );
        return totalOfDiscountedPrices;
    }

    public static void main( String[] args ) {
        /*
         * What was that about API and Copyright? Arrays.asList is a Guava
         * thing!
         */
        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal( "10" ),
                new BigDecimal( "30" ),
                new BigDecimal( "17" ),
                new BigDecimal( "20" ),
                new BigDecimal( "15" ),
                new BigDecimal( "18" ),
                new BigDecimal( "45" ),
                new BigDecimal( "12" ) );

        Discounter discounter = new Discounter();
        System.out.println( "imperativeDiscounter() => " + discounter.imperativeDiscounter( prices ) );
        System.out.println( "functionalDiscounter() => " + discounter.functionalDiscounter( prices ) );
    }

}
