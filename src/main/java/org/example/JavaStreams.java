package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main(String[] args) {
        // Activity 1: Filter Odd Numbers
        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        List<Integer> oddNums = nums.stream().filter(isOdd).toList();
        System.out.print("Odd numbers: ");
        System.out.println(oddNums);
        System.out.println();

        // Activity 2: Filter Strings Starting with 'A'
        List<String> names = List.of( "Alice", "Adam", "Bob", "Angela", "Brian");
        Predicate<String> startsWithA = s -> s.startsWith("A");
        List<String> nameStartingWithA = names.stream().filter(startsWithA).toList();
        System.out.print("Names starting with A: ");
        System.out.println(nameStartingWithA);
        System.out.println();

        // Activity 3: Square All Numbers
        List<Integer> nums2 = List.of(1, 2, 3, 4, 5);
        List<Integer> squaredNums = nums2.stream().map(n -> n * n).toList();
        System.out.print("Squared numbers: ");
        System.out.println(squaredNums);
        System.out.println();

        // Activity 4: Combine Predicates
        List<Integer> nums3 = List.of(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> greaterThanFive = n -> n > 5;
        List<Integer> isEvenAndGreaterThanFive = nums3.stream().filter(isEven.and(greaterThanFive)).toList();
        System.out.print("Even and >5: ");
        System.out.println(isEvenAndGreaterThanFive);
        System.out.println();

        // Activity 5: Sort Objects Using Comparator
        List<Person> people = List.of(
                new Person("Gideon", 18),
                new Person("Earl", 29),
                new Person("Dzelle", 22),
                new Person("Kayne", 31),
                new Person("Luis", 12)
                );
        List<Person> sortedByAgeAscending = people.stream().sorted(Comparator.comparingInt(Person::getAge)).toList();
        List<Person> sortedByName = people.stream().sorted(Comparator.comparing(Person::getName)).toList();
        List<Person> sortedByAgeDescending = people.stream().sorted(Comparator.comparingInt(Person::getAge).reversed()).toList();

        System.out.println("Sorted by age (ascending): ");
        sortedByAgeAscending.forEach(p -> System.out.println(p.toString()));
        System.out.println();

        System.out.println("Sorted by name: ");
        sortedByName.forEach(p -> System.out.println(p.toString()));
        System.out.println();

        System.out.println("Sorted by age (descending): ");
        sortedByAgeDescending.forEach(p -> System.out.println(p.toString()));

    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.age;
    }
}