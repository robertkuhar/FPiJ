package ch03;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

public class Compare {

    public static void main( String[] args ) {
        final List<Person> people = Arrays.asList(
                new Person( "Robert", 49 ),
                new Person( "John", 20 ),
                new Person( "Sara", 21 ),
                new Person( "Chloe", 18 ),
                new Person( "Jane", 21 ),
                new Person( "Greg", 35 ) );

        final List<Person> ascendingByAge = people.stream().sorted( ( p1, p2 ) -> p1.age - p2.age ).collect( toList() );
        printPeople( "ascendingByAge", ascendingByAge );

        final List<Person> ascendingByAgeAlt = people.stream().sorted( Compare::compareByAge ).collect( toList() );
        printPeople( "ascendingByAgeAlt", ascendingByAgeAlt );

    }

    // BobK doesn't think the compareByAge method belongs on Person.
    static int compareByAge( Person p1, Person p2 ) {
        return p1.age - p2.age;
    }

    public static void printPeople( final String message, final List<Person> people ) {
        System.out.println( message );
        people.forEach( System.out::println );
    }

}
