package ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class OlderThan20 {

    public static void main( String[] args ) {
        final List<Person> people = Arrays.asList(
                new Person( "Robert", 49 ),
                new Person( "John", 20 ),
                new Person( "Sara", 21 ),
                new Person( "Chloe", 18 ),
                new Person( "Jane", 21 ),
                new Person( "Greg", 35 ) );

        List<Person> olderThan20_a = new ArrayList<>();
        people.stream().filter( person -> person.age > 20 ).forEach( person -> olderThan20_a.add( person ) );
        printPeople( "don't trust olderThan20_a", olderThan20_a );

        List<Person> olderThan20_b = people.stream().filter( person -> person.age > 20 )
                .collect( ArrayList::new, ArrayList::add, ArrayList::addAll );
        printPeople( "don't trust olderThan20_b", olderThan20_b );

        List<Person> olderThan20_c = people.stream().filter( person -> person.age > 20 ).collect( Collectors.toList() );
        printPeople( "don't trust olderThan20_c", olderThan20_c );

        Map<Integer, List<Person>> peopleByAge = people.stream().collect( Collectors.groupingBy( person -> person.age ) );
        System.out.println( "Grouped by age: " + peopleByAge );

        Map<Integer, List<String>> nameOfPeopleByAge = people.stream().collect(
                Collectors.groupingBy( person -> person.age, Collectors.mapping( person -> person.name, Collectors.toList() ) ) );
        System.out.println( "People grouped by age: " + nameOfPeopleByAge );

        // Group the names by their first char and then get the oldest person in
        // each group
        Comparator<Person> byAge = Comparator.comparing( person -> person.age );
        Map<Character, Optional<Person>> oldestPersonOfEachLetter = people.stream().collect(
                Collectors.groupingBy( person -> person.name.charAt( 0 ), Collectors.reducing( BinaryOperator.maxBy( byAge ) ) ) );
        System.out.println( "Oldest person of each letter:" );
        System.out.println( oldestPersonOfEachLetter );
    }

    public static void printPeople( final String message, final List<Person> people ) {
        System.out.println( message );
        people.forEach( System.out::println );
    }

}
