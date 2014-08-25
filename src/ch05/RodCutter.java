/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch05;

import java.util.List;

public class RodCutter {
    private boolean mustFail;

    public RodCutter( final boolean fail ) {
        mustFail = fail;
    }

    public void setPrices( final List<Integer> prices ) {
        // ...
        if ( mustFail ) {
            throw new RodCutterException();
        }
    }

    public int maxProfit( final int length ) {
        if ( length == 0 ) {
            throw new RodCutterException();
        }
        return 0;
    }

}
