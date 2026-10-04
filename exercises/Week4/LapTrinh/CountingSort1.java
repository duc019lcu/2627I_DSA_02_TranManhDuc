import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountingSort1 {

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(100, 0));

        for (int num : arr) {
            result.set(num, result.get(num) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        List<Integer> freq = countingSort(arr);
        for (int i = 0; i < freq.size(); i++) {
            System.out.print(freq.get(i) + (i == freq.size() - 1 ? "" : " "));
        }
        System.out.println();
        sc.close();
    }
}