/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch04;

public class DefaultMethods {
    public interface Fly {
        default void takeOff() {
            System.out.println( "Fly::takeOff" );
        }

        default void land() {
            System.out.println( "Fly::land" );
        }

        default void turn() {
            System.out.println( "Fly::turn" );
        }

        default void cruise() {
            System.out.println( "Fly::cruise" );
        }
    }

    public interface FastFly extends Fly {
        default void takeOff() {
            System.out.println( "FastFly::takeOff" );
        }
    }

    public interface Sail {
        default void cruise() {
            System.out.println( "Sail::cruise" );
        }

        default void turn() {
            System.out.println( "Sail::turn" );
        }
    }

    public class Vehicle {
        public void turn() {
            System.out.println( "Vehicle::turn" );
        }
    }

    public class SeaPlane extends Vehicle implements FastFly, Sail {
        private int altitude;

        // ...
        public void cruise() {
            System.out.print( "SeaPlane::cruise currently cruise like: " );
            if ( altitude > 0 ) {
                FastFly.super.cruise();
            } else {
                Sail.super.cruise();
            }
        }
    }

    public void useClasses() {
        SeaPlane seaPlane = new SeaPlane();
        seaPlane.takeOff();
        seaPlane.turn();
        seaPlane.cruise();
        seaPlane.land();
    }

    public static void main( final String[] args ) {
        new DefaultMethods().useClasses();
    }
}
