package exercises.Week11.BaiTap;

import java.util.ArrayList;
import java.util.List;

public class MissingNumbers3 {

    public static List<Integer> missingNumbers(int[] a, int[] b) {
        List<Integer> missing = new ArrayList<>();
        if (b.length == 0) {
            return missing;
        }

        int minB = b[0];
        for (int x : b) {
            if (x < minB) {
                minB = x;
            }
        }

        int[] count = new int[101];
        for (int x : b) {
            count[x - minB]++;
        }
        for (int x : a) {
            int idx = x - minB;
            if (idx >= 0 && idx < count.length) {
                count[idx]--;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                missing.add(i + minB);
            }
        }
        return missing;
    }
}