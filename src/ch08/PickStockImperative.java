/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch08;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class PickStockImperative {
    public static void main( final String[] args ) {
        long start = System.currentTimeMillis();
        final List<StockInfo> stocks = new ArrayList<>();
        for ( String symbol : Tickers.symbols ) {
            stocks.add( StockUtil.getPrice( symbol ) );
        }

        final List<StockInfo> stocksPricedUnder500 = new ArrayList<>();
        final Predicate<StockInfo> isPriceLessThan500 = StockUtil.isPriceLessThan( 500 );
        for ( StockInfo stock : stocks ) {
            if ( isPriceLessThan500.test( stock ) ) {
                stocksPricedUnder500.add( stock );
            }
        }

        StockInfo highPriced = new StockInfo( "", BigDecimal.ZERO );
        for ( StockInfo stock : stocksPricedUnder500 ) {
            highPriced = StockUtil.pickHigh( highPriced, stock );
        }
        System.out.println( "High priced under $500 is " + highPriced );
        System.out.println( "Elapsed: " + ( System.currentTimeMillis() - start ) + "ms PickStockImperative" );
    }
}
