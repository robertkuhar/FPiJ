/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch06;

import java.util.function.Supplier;

public class Evaluation {
    public static boolean evaluate( final int value ) {
        System.out.println( "evaluating..." + value );
        simulateTimeConsumingOp( 2000 );
        return value > 100;
    }

    public static void simulateTimeConsumingOp( final int millseconds ) {
        try {
            Thread.sleep( millseconds );
        } catch ( Exception ex ) {
            throw new RuntimeException( ex );
        }
    }

    public static void eagerEvaluator( final boolean input1, final boolean input2 ) {
        System.out.println( "eagerEvaluator called..." );
        System.out.println( "accept?: " + ( input1 && input2 ) );
    }

    public static void lazyEvaluator( final Supplier<Boolean> input1, final Supplier<Boolean> input2 ) {
        System.out.println( "lazyEvaluator called..." );
        System.out.println( "accept?: " + ( input1.get() && input2.get() ) );
    }

    public static void main( final String[] args ) {

        System.out.println( "//" + "START:EAGER_OUTPUT" );
        eagerEvaluator( evaluate( 1 ), evaluate( 2 ) );
        System.out.println( "//" + "END:EAGER_OUTPUT" );

        System.out.println( "//" + "START:LAZY_OUTPUT" );
        lazyEvaluator( ( ) -> evaluate( 1 ), ( ) -> evaluate( 2 ) );
        System.out.println( "//" + "END:LAZY_OUTPUT" );
    }

}
