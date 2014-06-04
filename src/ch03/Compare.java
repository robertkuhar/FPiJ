package ch03;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Compare {

    public static void main( String[] args ) {
        final List<Person> people = Arrays.asList(
                new Person( "Robert", 49 ),
                new Person( "John", 20 ),
                new Person( "Sara", 21 ),
                new Person( "Chloe", 18 ),
                new Person( "Jane", 21 ),
                new Person( "Greg", 35 ) );

        printPeople( "ascendingByAge", sortORama( people, ( p1, p2 ) -> p1.age - p2.age ) );
        printPeople( "ascendingByAgeAlt", sortORama( people, Compare::compareByAge ) );

        Comparator<Person> compareAscending = ( p1, p2 ) -> p1.age - p2.age;
        Comparator<Person> compareDescending = compareAscending.reversed();
        Comparator<Person> bobsDescending = ( p1, p2 ) -> -compareAscending.compare( p1, p2 );

        printPeople( "compareAscending", sortORama( people, compareAscending ) );
        printPeople( "compareDescending", sortORama( people, compareDescending ) );
        printPeople( "bobsDescending", sortORama( people, bobsDescending ) );

        printPeople( "ascendingByName", sortORama( people, ( p1, p2 ) -> p1.name.compareTo( p2.name ) ) );

        // Argh. Too bad we don't get partially applied functions then I could
        // all System.out.printf this
        people.stream().min( compareAscending ).ifPresent( p -> System.out.printf( "youngest %s\n", p ) );
        people.stream().max( compareAscending ).ifPresent( p -> System.out.printf( "oldest %s\n", p ) );
    }

    /**
     * Bob just can't quit his procedural ways!?! Am I functional? Is this a
     * higher order function? Probably not as it does something rather than
     * return a function that does something.
     * 
     * @param list of Person to be sorted.
     * @param c Comparator function
     * @return
     */
    static List<Person> sortORama( List<Person> list, Comparator<Person> c ) {
        return list.stream().sorted( c ).collect( toList() );
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
