package CollectionsInterview;

import java.util.LinkedList;
import java.util.List;

public class MergeLists {
    public static void main(String[] args) {
        LinkedList<Integer> ll1 = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        LinkedList<Integer> ll2 = new LinkedList<>(List.of(6, 7, 8, 9, 10));

        System.out.println(mergeLists(ll1, ll2));
    }

    private static List mergeLists(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
        ll1.addAll(ll2);
        return ll1;
    }
}
