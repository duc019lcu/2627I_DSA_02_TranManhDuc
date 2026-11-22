package exercises.Week11.BaiTap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissingNumbers1 {

    public static List<Integer> missingNumbers(int[] a, int[] b) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : b) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        for (int x : a) {
            freq.put(x, freq.getOrDefault(x, 0) - 1);
        }

        List<Integer> missing = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 0) {
                missing.add(entry.getKey());
            }
        }

        Collections.sort(missing);
        return missing;
    }

}