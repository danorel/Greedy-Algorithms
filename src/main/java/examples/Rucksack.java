package examples;

import java.util.*;
import java.util.stream.Collectors;

public class Rucksack {
    public static int
        calculate(
            int amount,
            int  limit) {
        int
                min = 1,
                max = 50;
        /*
            Initialization of weight/value per item
         */
        HashMap<Integer, Integer> weightByValue = new HashMap<>();
        for(int index = 0; index < amount; ++index) {
            weightByValue.put(
                    (int) (min + Math.random() * (max - min)),
                    (int) (min + Math.random() * (max - min))
            );
        }
        /*
            Print the received weights : values of the items
         */
        System.out.println("Default view of rucksack: ");
        int index = 1;
        for(Integer weight : weightByValue.keySet()){
            System.out.println(
                    new StringBuilder()
                            .append("Item ")
                            .append(index++)
                            .append(" : ")
                            .append("weight: ")
                            .append(weight)
                            .append(", ")
                            .append("value: ")
                            .append(weightByValue.get(weight))
            );
        }
        return calculate(
                amount,
                limit,
                weightByValue
        );
    }

    public static int
        calculate(
            int    amount,
            int     limit,
            HashMap<Integer, Integer> weightByValue) {
        int
                capacity   = 0,
                evaluation = 0;
        /*
            Sort in descending by value order
         */
        Map<Integer, Integer> weightByValueSorted =
                weightByValue
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors
                                .toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (e1, e2) -> e1,
                                        LinkedHashMap::new
                                )
                        );
        System.out.println("Sorted rucksack by value parameter: ");
        int index = 1;
        for(Integer weight : weightByValueSorted.keySet()){
            System.out.println(
                    new StringBuilder()
                            .append("Item ")
                            .append(index++)
                            .append(" : ")
                            .append("weight: ")
                            .append(weight)
                            .append(", ")
                            .append("value: ")
                            .append(weightByValue.get(weight))
            );
        }
        /*
            Greedy choose the items
         */
        for(Integer weight : weightByValueSorted.keySet()) {
            if(capacity + weight < limit) {
                capacity   += weight;
                evaluation += weightByValueSorted.get(weight);
            } else {
                break;
            }
        }
        return evaluation;
    }
}
