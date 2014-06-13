/***
 * Excerpted from "Functional Programming in Java", published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch03;

public class IterateString {

    public static void main( String[] args ) {
        final String str = "w00t";
        lambdaStringIterate_ctoi( str );
        methodRefStringIterate_ctoi( str );
        myMethodRefStringIterage( str );
        mapToObjStringIterate( str );
        filterDigitsStringIterate( str );
        methodRefFilterDigitsStringIterate( str );
    }

    static void lambdaStringIterate_ctoi( final String s ) {
        System.out.println( "lambdaStringIteration( s: " + s + " )" );
        s.chars()
                .forEach( ch -> System.out.println( ch ) );
    }

    static void methodRefStringIterate_ctoi( final String s ) {
        System.out.println( "methodReferenceIteration( s: " + s + " )" );
        s.chars()
                .forEach( System.out::println );
    }

    private static void printChar( int i ) {
        System.out.println( (char) i );
    }

    private static void myMethodRefStringIterage( String s ) {
        System.out.println( "myMethodRefStringIterage( s: " + s + " )" );
        s.chars()
                .forEach( IterateString::printChar );
    }

    private static void mapToObjStringIterate( String s ) {
        System.out.println( "mapToObjStringIterate( s: " + s + " )" );
        s.chars()
                .mapToObj( ch ->  (char) ch  )
                .forEach( System.out::println );
    }

    private static void filterDigitsStringIterate( String s ) {
        System.out.println( "filterDigitsStringIterate( s: " + s + " )" );
        s.chars()
                .filter( ch -> Character.isDigit( ch ) )
                .forEach( i -> printChar( i ) );
    }

    private static void methodRefFilterDigitsStringIterate( String s ) {
        System.out.println( "methodRefFilterDigitsStringIterate( s: " + s + " )" );
        s.chars()
                .filter( ch -> Character.isDigit( ch ) )
                .forEach( IterateString::printChar );
    }
}
