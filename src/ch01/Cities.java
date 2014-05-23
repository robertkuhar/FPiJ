/***
 * Excerpted from "Functional Programming in Java", published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch01;

import java.util.Arrays;
import java.util.List;

public class Cities {
    public static void findChicagoImperative( final List<String> cities ) {
        boolean found = false;
        for ( String city : cities ) {
            if ( city.equals( "Chicago" ) ) {
                found = true;
                break;
            }
        }
        System.out.println( "Found chicago?:" + found );
    }

    public static void findChicagoDeclarative( final List<String> cities ) {
        System.out.println( "Found chicago?:" + cities.contains( "Chicago" ) );
    }

    public static void main( final String[] args ) {
        List<String> cities = Arrays.asList( "Albany", "Boulder", "Chicago", "Denver", "Eugene" );
        findChicagoImperative( cities );
        findChicagoDeclarative( cities );
    }
}
