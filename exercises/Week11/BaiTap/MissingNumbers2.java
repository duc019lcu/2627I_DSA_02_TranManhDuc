package exercises.Week11.BaiTap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumbers2 {

    public static List<Integer> missingNumbers(int[] a, int[] b) {
        int[] aCopy = Arrays.copyOf(a, a.length);
        int[] bCopy = Arrays.copyOf(b, b.length);

        Arrays.sort(aCopy);
        Arrays.sort(bCopy);

        List<Integer> missing = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (j < bCopy.length) {
            if (i < aCopy.length && aCopy[i] == bCopy[j]) {
                i++;
                j++;
            } else if (i < aCopy.length && aCopy[i] < bCopy[j]) {
                i++;
            } else {
                if (missing.isEmpty() || missing.get(missing.size() - 1) != bCopy[j]) {
                    missing.add(bCopy[j]);
                }
                j++;
            }
        }
        return missing;
    }
}