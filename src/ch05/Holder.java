/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch05;

import java.util.function.Supplier;

public class Holder {
    private Supplier<Heavy> heavy = ( ) -> createAndCacheHeavy();

    public Holder() {
        System.out.println( "Holder created" );
    }

    private synchronized Heavy createAndCacheHeavy() {
        class HeavyFactory implements Supplier<Heavy> {
            private final Heavy heavyInstance = new Heavy();

            public Heavy get() {
                return heavyInstance;
            }
        }
        if ( !HeavyFactory.class.isInstance( heavy ) ) {
            heavy = new HeavyFactory();
        }
        return heavy.get();
    }

    public synchronized Heavy getHeavy() {
        return heavy.get();
    }

    public static void main( final String[] args ) {
        final Holder holder = new Holder();
        System.out.println( "deferring heavy creation..." );
        System.out.println( holder.getHeavy() );
        System.out.println( holder.getHeavy() );
    }
}
