/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch04;

public class MailBuilder {
    public MailBuilder from( final String address ) {
        return this;
    }

    public MailBuilder to( final String address ) {
        return this;
    }

    public MailBuilder subject( final String line ) {
        return this;
    }

    public MailBuilder body( final String message ) {
        return this;
    }

    public void send() {
        System.out.println( "sending..." );
    }

    public static void main( final String[] args ) {
        MailBuilder mailer = new MailBuilder().from( "build@agiledeveloper.com" ).to( "venkats@agiledeveloper.com" )
                .subject( "build notification" ).body( "...your code sucks..." );
        mailer.send();
    }
}
