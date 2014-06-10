/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch04;

import java.util.function.Consumer;

public class FluentMailer {
    private FluentMailer() {
    }

    public FluentMailer from( final String address ) {
        /* ... */
        return this;
    }

    public FluentMailer to( final String address ) {
        /* ... */
        return this;
    }

    public FluentMailer subject( final String line ) {
        /* ... */
        return this;
    }

    public FluentMailer body( final String message ) {
        /* ... */
        return this;
    }

    public static void send( final Consumer<FluentMailer> block ) {
        final FluentMailer mailer = new FluentMailer();
        block.accept( mailer );
        System.out.println( "sending..." );
    }

    public static void main( final String[] args ) {
        // BobK: Where the fuck did mailer come from (or bob as the case may
        // be)? How is it that bob is an instanceof FluentMailer?
        FluentMailer.send( bob -> bob.from( "build@agiledeveloper.com" )
                .to( "venkats@agiledeveloper.com" )
                .subject( "build notification" )
                .body( "...much better..." ) );
    }

}
