import java.util.HashSet;
import java.util.Set;

public class Pairs {

    // Đếm số cặp có hiệu bằng k (các phần tử trong mảng phân biệt)
    public static int pairs(int k, int[] arr) {
        Set<Long> set = new HashSet<>();
        for (int num : arr) {
            set.add((long) num);
        }

        int count = 0;
        for (int num : arr) {
            if (set.contains((long) num + k)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] arr = {1, 5, 3, 4, 2};
        // Các cặp thỏa mãn chênh lệch bằng 2: (1, 3), (3, 5), (2, 4) -> 3 cặp
        System.out.println("Số cặp có chênh lệch bằng " + k + " là: " + pairs(k, arr));
    }
}