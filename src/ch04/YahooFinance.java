/***
 * Excerpted from "Functional Programming in Java", published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

public class YahooFinance {
    public static BigDecimal getPrice( final String ticker ) {
        try {
            final URL url = new URL( "http://ichart.finance.yahoo.com/table.csv?s=" + ticker );
            final BufferedReader reader = new BufferedReader( new InputStreamReader( url.openStream() ) );
            final String data = reader.lines()
                    .skip( 1 )
                    .findFirst()
                    .get();
            final String[] dataItems = data.split( "," );
            return new BigDecimal( dataItems[dataItems.length - 1] );
        } catch ( Exception ex ) {
            throw new RuntimeException( ex );
        }
    }
}
