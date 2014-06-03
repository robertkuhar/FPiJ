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
