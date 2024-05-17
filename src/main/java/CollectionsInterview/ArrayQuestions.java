package CollectionsInterview;

import java.util.Arrays;

public class ArrayQuestions {

    public static void main(String[] args) {
        Integer array[] = new Integer[]{
                1, 2, 3, 6, 5654654, 5, 64, 56, 45, 645, 64, 564,
        };
        Arrays.stream(array).forEach(System.out::println);
        reverseArray(array);
    }

    private static void reverseArray(Integer[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;

        }
        System.out.println("*************************");
        Arrays.stream(array).forEach(System.out::println);
    }
}
