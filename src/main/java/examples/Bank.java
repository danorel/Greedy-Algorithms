package examples;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Bank {
    public static int calculate(
            int n) {
        LinkedList<Integer> available = new LinkedList<>();
        available.add(500);
        available.add(200);
        available.add(100);
        available.add(50);
        available.add(20);
        available.add(10);
        return calculate(
                available,
                0,
                n
        );
    }
    public static int calculate(
            LinkedList<Integer> available,
            int starter,
            int n
    ) {
        int[] combinations = new int[n + 1];
        int   index = n;
        boolean found = false;
        while(index != 0) {
            for(Integer paper : available) {
                if(index / paper >= 1) {
                    combinations[index - paper] += combinations[index] + 1;
                    index -= paper;
                    found = true;
                    break;
                }
            }
            if(!found)
                return -1;
            found = false;
        }
        return combinations[0];
    }
}
