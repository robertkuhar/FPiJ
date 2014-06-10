/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch04;

public class Mailer {
    public void from( final String address ) {
    }

    public void to( final String address ) {
    }

    public void subject( final String line ) {
    }

    public void body( final String message ) {
    }

    public void send() {
        System.out.println( "sending..." );
    }

    public static void main( final String[] args ) {
        Mailer mailer = new Mailer();
        mailer.from( "build@agiledeveloper.com" );
        mailer.to( "venkats@agiledeveloper.com" );
        mailer.subject( "build notification" );
        mailer.body( "...your code sucks..." );
        mailer.send();
    }
}
