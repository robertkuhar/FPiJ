/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch09;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Performance {
    public static double timeIt( final Runnable block ) {
        final long start = System.nanoTime();
        block.run();
        final long end = System.nanoTime();
        return ( end - start ) / 1.0e9;
    }

    // BobK I find it interesting that he didn't call ch06.PrimeFinder here
    public static boolean isPrime( final long number ) {
        for ( long i = 2; i <= Math.sqrt( number ); i++ ) {
            if ( number % i == 0 ) {
                return false;
            }
        }
        return number > 1;
    }

    public static void main( String[] args ) {
        final int limit = 100_000;
        final int iterations = 100;
        final String format = "%g seconds";

        List<Long> numbers = Stream.iterate( 1L, number -> number + 1 )
                .limit( limit )
                .collect( Collectors.<Long> toList() );

        {
            System.out.println( "//" + "START:HABITUAL_OUTPUT" );
            double time = 0;

            for ( int i = 0; i < iterations; i++ ) {
                time += timeIt( ( ) -> {
                    long primesCount = 0;
                    for ( long number : numbers ) {
                        if ( isPrime( number ) ) {
                            primesCount += 1;
                        }
                    }
                    // System.out.println(primesCount);
                } );
            }
            System.out.println( String.format( format, time / iterations ) );
            System.out.println( "//" + "END:HABITUAL_OUTPUT" );
        }

        {
            System.out.println( "//" + "START:LAMBDA_OUTPUT" );
            double time = 0;
            for ( int i = 0; i < iterations; i++ ) {
                time += timeIt( ( ) -> {
                    final long primesCount = numbers.stream()
                            .filter( number -> isPrime( number ) )
                            .count();
                    // System.out.println(primesCount);
                } );
            }

            System.out.println( String.format( format, time / iterations ) );
            System.out.println( "//" + "END:LAMBDA_OUTPUT" );
        }

        {
            System.out.println( "//" + "START:PARALLEL_OUTPUT" );
            double time = 0;
            for ( int i = 0; i < iterations; i++ ) {
                time += timeIt( ( ) -> {
                    final long primesCount = numbers.parallelStream()
                            .filter( number -> isPrime( number ) )
                            .count();
                    // System.out.println(primesCount);
                } );
            }

            System.out.println( String.format( format, time / iterations ) );
            System.out.println( "//" + "END:PARALLEL_OUTPUT" );
        }
    }
}
