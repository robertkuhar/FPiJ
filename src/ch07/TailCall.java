/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch07;

import java.util.stream.Stream;

@FunctionalInterface
public interface TailCall<T> {

    TailCall<T> apply();

    default boolean isComplete() {
        return false;
    }

    default T result() {
        throw new Error( "not implemented" );
    }

    default T invoke() {
        return Stream.iterate( this, TailCall::apply )
                .filter( TailCall::isComplete )
                .findFirst()
                .get()
                .result();
    }
}
