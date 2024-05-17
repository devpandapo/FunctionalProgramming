package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Predicate evenPredicate = (num) -> num  % 2 != 0;
//        filterandPrint(evenPredicate);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");


    }

    private static void filterandPrint(Predicate evenPredicate) {
        IntStream.range(1, 10000).filter((IntPredicate) evenPredicate).forEach(System.out::println);
    }

    private static void reverseStringSorted(List<String> courses) {
        courses.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
    }

    private static void sortStringswithLength(List<String> courses) {
        courses.stream().sorted(Comparator.comparing((str) -> str.length())).forEach(System.out::println);
    }

    private static void sortStrings(List<String> courses) {
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void sortRandomIntegers() {
        new Random().ints(1, 10000000).limit(1000000).sorted().forEach(System.out::println);
    }

    private static void extracted2() {
        System.out.println(IntStream.range(1, 100).reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
    }

    private static void extracted1() {
        System.out.println(IntStream.range(1, 100).reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y));
    }

    private static void extracted() {
        System.out.println(IntStream.range(1, 11).filter((num) -> num % 2 != 0).map((num) -> num = num * num * num).reduce(0, Integer::sum));
    }

}