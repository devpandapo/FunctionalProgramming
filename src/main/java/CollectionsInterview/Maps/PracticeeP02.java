package CollectionsInterview.Maps;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

record Notes(Integer tagname, String nname, Integer tagid) {
}

public class PracticeeP02 {
    public static void main(String[] args) {
        countEachElement();
        countDuplicateElement();
        countDuplicateElement1();


    }

    private static void countEachElement() {
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println("Word:\t" + k + "\t Count:\t" + v));
    }

    private static void countDuplicateElement() {
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).
                collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(), (e1, e2) -> e2)).
                forEach((k, v) -> System.out.println("Word:\t" + k + "\t Count:\t" + v));
    }

    private static void countDuplicateElement1() {
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        names.stream().filter(name -> Collections.frequency(names, name) > 1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                forEach((k, v) -> System.out.println("Word:\t" + k + "\t Count:\t" + v));
    }

    private static void methodtoAddMaptoObjects() {
        record Note(int tagId, String tagName, int tagValue) {
        }

        List<Note> noteLst = new ArrayList<>();
        noteLst.add(new Note(1, "note1", 11));
        noteLst.add(new Note(2, "note2", 22));
        noteLst.add(new Note(3, "note3", 33));
        noteLst.add(new Note(4, "note4", 44));
        noteLst.add(new Note(5, "note5", 55));

        noteLst.add(new Note(6, "note4", 66));

        // Convert list to map with sorted keys
        Map<String, Integer> notesRecords = noteLst.stream()
                .sorted(Comparator.comparingInt(Note::tagId).reversed())
                .collect(Collectors.toMap(
                        Note::tagName,
                        Note::tagId,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("Notes : " + notesRecords);
    }


    private static boolean checkduplicatelementinArray() {
        //        listints.stream().sorted(Integer::compare).forEach(System.out::println);
        int nums[] = new Random().ints(10, 1, 10).toArray();
        Set<Integer> setnums = new HashSet<>();
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println("Filtered is ");
        Optional<Integer> first = Arrays.stream(nums).boxed().filter((num) -> !setnums.add(num)).findFirst();
        System.out.println(first);
        return first.isPresent() ? true : false;
    }

    private static boolean checkDuplicateElementInArray() {
        return Arrays.stream(new Random().ints(10, 1, 10).toArray())
                .boxed()
                .peek(System.out::println)
                .collect(Collectors.toCollection(HashSet::new))
                .size() < 10;
    }

    private static void countnonrepeatingCharacter() {
        String input = "Java aricles are Awesome";
        System.out.println(input.chars().mapToObj(s ->
                Character.toLowerCase(Character.valueOf((char) s))).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                Collectors.counting())).entrySet().stream().filter((entry) -> entry.getValue() > 1).findFirst());
    }

    private static List<Integer> generateAndPrintRandomInts() {
        var listints = new Random().ints(10000000, 1, 10000000).boxed().collect(Collectors.toList());
//        var listints = List.of(new Random().nextInt(), new Random().nextInt(), new Random().nextInt(), new Random().nextInt());
        listints.stream().forEach(System.out::println);
        return listints;
    }

    private static void findDuplicateElementsInTheStream(List<Integer> listints) {
        Set<Integer> set = new HashSet<>();
        listints.stream().filter((ints) -> !set.add(ints)).forEach(System.out::println);
    }

}


