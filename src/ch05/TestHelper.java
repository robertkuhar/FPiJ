/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch05;

import static org.junit.Assert.fail;

public class TestHelper {
    public static <X extends Throwable> Throwable assertThrows( final Class<X> exceptionClass, final Runnable block ) {
        try {
            block.run();
        } catch ( Throwable ex ) {
            if ( exceptionClass.isInstance( ex ) ) {
                return ex;
            }
        }
        fail( "Failed to throw expected exception " );
        return null;
    }
}
