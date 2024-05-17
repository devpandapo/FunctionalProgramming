package CollectionsInterview.Maps;

import java.util.*;

public class SortMapByValues {
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
        sortMapByValues(mapByValues);
//        abc(mapByValues);
    }

    private static void sortMapByValues(Map<String, Integer> mapByValues) {
        Map<String, Integer> mapcopy = new LinkedHashMap<>();
//        mapByValues.forEach(Comparator.comparing());
//        mapcopy.putAll();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(mapByValues.entrySet());
        Collections.sort(list, Map.Entry.comparingByValue());

        for (Map.Entry<String, Integer> e : list) {
            mapcopy.put(e.getKey(), e.getValue());
        }
        System.out.println("*************SORTED MAP IS ********************");
        mapcopy.forEach((k, v) -> {
            System.out.println("Key:" + k + "Value:" + v);
        });
    }

    public static void abc(Map<String, Integer> unsortedMap) {
        // Convert map to list of entries
        List<Map.Entry<String, Integer>> list = new ArrayList<>(unsortedMap.entrySet());

        // Sort the list based on values
        Collections.sort(list, Map.Entry.comparingByValue());

        // Create a new LinkedHashMap to store sorted entries
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Print the sorted map
        System.out.println("Sorted Map by Values:");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}


