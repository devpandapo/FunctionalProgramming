package CollectionsInterview.Maps;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeClass1 {
    public static void main(String[] args) {
        Map<String, Integer> mapByValues = new HashMap<>();
        mapByValues.put(String.valueOf(UUID.randomUUID()), new Random().nextInt());
        mapByValues.put(String.valueOf(UUID.randomUUID()), new Random().nextInt());
        mapByValues.put(String.valueOf(UUID.randomUUID()), new Random().nextInt());
        mapByValues.put(String.valueOf(UUID.randomUUID()), new Random().nextInt());
        mapByValues.put(String.valueOf(UUID.randomUUID()), new Random().nextInt());
        mapByValues.put(String.valueOf(UUID.randomUUID()), new Random().nextInt());
        mapByValues.put(String.valueOf(UUID.randomUUID()), new Random().nextInt());
        mapByValues.put(String.valueOf(UUID.randomUUID()), new Random().nextInt());
        mapByValues.put(String.valueOf(UUID.randomUUID()), new Random().nextInt());
        mapByValues.forEach((k, v) -> {
            System.out.println("Key:" + k + "Value:" + v);
        });
//        sortMapByValues(mapByValues);


        mapByValues.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)).
                forEach((k, v) -> System.out.println("Key:\t" + k + "\tValue:\t" + v));
//        sortMapByValuesUsingStream(mapByValues).forEach((k, v) -> System.out.println("Key:\t" + k + "\t Value:\t" + v));
//        abc(mapByValue
    }

    private static void sortMapByValues(Map<String, Integer> mapByValues) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(mapByValues.entrySet());
        Collections.sort(list, Collections.reverseOrder(Map.Entry.comparingByValue()));
        Map<String, Integer> mapcopy = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            mapcopy.put(entry.getKey(), entry.getValue());
        }
        System.out.println("*******************SORTED MAP***************");
        mapcopy.forEach((k, v) -> System.out.println("Key:\t" + k + "\tValue:\t" + v));
    }

    private static Map<String, Integer> sortMapByValuesUsingStream(Map<String, Integer> mapByValues) {
        return mapByValues.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(
                Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}
