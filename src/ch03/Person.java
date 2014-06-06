/***
 * Excerpted from "Functional Programming in Java", published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch03;

import java.util.Objects;

public class Person {
    public final String name;
    public final int age;

    public Person( String name, int age ) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash( name, age );
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( !( obj instanceof Person ) ) {
            return false;
        }
        Person that = (Person) obj;
        return ( Objects.equals( this.name, that.name ) && this.age == that.age );
    }

    public String toString() {
        return String.format( "Person( name: %s, age: %d )", name, age );
    }

}
