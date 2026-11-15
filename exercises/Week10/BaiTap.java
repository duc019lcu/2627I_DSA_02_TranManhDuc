package exercises.Week10;

import java.util.Scanner;

public class BaiTap {

    static class Result {
        int min;
        int max;

        public Result(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static Result findMinMax(int[] a, int low, int high) {
        if (low == high) {
            return new Result(a[low], a[low]);
        }

        if (high == low + 1) {
            if (a[low] < a[high]) {
                return new Result(a[low], a[high]);
            } else {
                return new Result(a[high], a[low]);
            }
        }

        int mid = low + (high - low) / 2;

        Result leftResult = findMinMax(a, low, mid);
        Result rightResult = findMinMax(a, mid + 1, high);

        int overallMin = Math.min(leftResult.min, rightResult.min);
        int overallMax = Math.max(leftResult.max, rightResult.max);

        return new Result(overallMin, overallMax);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        if (n > 0) {
            Result ans = findMinMax(a, 0, n - 1);
            System.out.println("Min: " + ans.min);
            System.out.println("Max: " + ans.max);
        } else {
            System.out.println("-1");
        }

        sc.close();
    }
}