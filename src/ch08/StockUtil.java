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
import java.util.function.Predicate;

import ch04.YahooFinance;

public class StockUtil {
    public static StockInfo getPrice( final String ticker ) {
        return new StockInfo( ticker, YahooFinance.getPrice( ticker ) );
    }

    public static Predicate<StockInfo> isPriceLessThan( final int price ) {
        return stockInfo -> stockInfo.price.compareTo( BigDecimal.valueOf( price ) ) < 0;
    }

    public static StockInfo pickHigh( final StockInfo stock1, final StockInfo stock2 ) {
        return stock1.price.compareTo( stock2.price ) > 0 ? stock1 : stock2;
    }
}
