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

public class StockInfo {
    public final String ticker;
    public final BigDecimal price;

    public StockInfo( final String symbol, final BigDecimal thePrice ) {
        ticker = symbol;
        price = thePrice;
    }

    public String toString() {
        return String.format( "ticker: %s price: %g", ticker, price );
    }
}
