package org.example;

import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class sadsadasdas {
    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        System.out.println(courses.stream().allMatch((e) -> e.getReviewScore() > 90));
        courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents).thenComparing(Comparator.comparing(Course::getReviewScore))).forEach(System.out::println);
        System.out.println(courses.stream().filter((review) -> review.getReviewScore() > 95).mapToInt(Course::getNoOfStudents).average());
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));


        String s = "Some Text\n" +
                "Some Text that will be saved\n" +
                "A lot of Text Present in here";
        s=s.replaceAll("\n", " ");
        System.out.println(s);
        System.out.println(Arrays.stream(s.split(" ")).peek(System.out::print).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }
}

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        super();
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }

}
