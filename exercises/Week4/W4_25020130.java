package exercises.Week4;

import java.util.Arrays;
import java.util.Scanner;

public class W4_25020130 {

    public static int computeHIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i; // Số bài báo có ít nhất citations[i] lượt trích dẫn
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        int[] citations = new int[n];
        for (int i = 0; i < n; i++) {
            citations[i] = sc.nextInt();
        }

        System.out.println(computeHIndex(citations));
        sc.close();
    }
}