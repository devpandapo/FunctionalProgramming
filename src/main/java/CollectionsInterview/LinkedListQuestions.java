package CollectionsInterview;

import java.util.*;

public class LinkedListQuestions {
    public static void main(String[] args) {
        //Find factorial of a number in java
//        System.out.println(IntStream.rangeClosed(1, 10000).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));

        //reverse a LinkedList in Java
        LinkedList<Integer> ll = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 67, 77, 7));
        var reverseLL = new LinkedList<Integer>();
//        Collections.reverse(ll);
        ll.forEach(System.out::println);
//        reverseLLway1(ll, reverseLL);

//        reverseLLWayno2(ll, reverseLL);
        reverseLLway1better(ll);

    }

    private static void reverseLLWayno2(LinkedList<Integer> ll, LinkedList<Integer> reverseLL) {
        ll.descendingIterator().forEachRemaining(reverseLL::add);
        reverseLL.forEach(System.out::println);
    }

    private static void reverseLLway1(LinkedList<Integer> ll, LinkedList<Integer> reverseLL) {
        for (int i = ll.size() - 1; i > 0; i--)
            reverseLL.add(ll.get(i));
        ll.forEach(System.out::println);
        reverseLL.forEach(System.out::println);
    }

    private static void reverseLLway1better(LinkedList<Integer> ll) {
        Integer temp;
        for (int i = 1; i <= ll.size() / 2; i++) {
            temp = ll.get(i - 1);
            ll.set(i - 1, ll.get(ll.size() - i));
            ll.set(ll.size() - i, temp);
        }
        ll.forEach(System.out::println);
    }

}
