package com.cognologix.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsCollectionOperations {

    class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }


        public String startsWith() {
            return name;
        }
    }

    @Test
    public void filterAndCollect() {

        /*
            Filter all persons having name starting with P and collect them in new List.
         */

        List<Person> persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12));

        List<Person> result =
                persons
                        .stream()
                        .filter(p -> p.name.startsWith("P"))
                        .collect(Collectors.toList());

        System.out.println(result);
        System.out.println("----------");
    }


    @Test
    public void groupByAge() {

        /*
            Collect all persons group by age.
            Need to collect output in Map
             age 18: [Max]
             age 23: [Peter, Pamela]
             age 12: [David]
         */

        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(e -> e.age));

        personsByAge
                .forEach((age, e) -> System.out.format("age %s: %s\n", age, e));
        System.out.println("--------------");

    }

    @Test
    public void calculateAverageAge() {
        /*
            Calculate average age of the persons.
         */
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        Double avgage = persons
                .stream()
                .collect(Collectors.averagingInt(e -> e.age));

        System.out.println(avgage);
        System.out.println("--------------------");


    }
}







