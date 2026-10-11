package exercises.Week5.LapTrinh;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class Bai2 {

    private static void merge(int[] a, int[] aux, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static void sort(int[] a, int[] aux, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, high);
        merge(a, aux, low, mid, high);
    }

    public static void mergeSort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static double timeTrial(int[] input) {
        int[] copy = Arrays.copyOf(input, input.length);
        long start = System.nanoTime();
        mergeSort(copy);
        long end = System.nanoTime();
        return (end - start) / 1_000_000.0;
    }

    private static double runAverage(int[] original, int trials) {
        double total = 0.0;
        for (int i = 0; i < trials; i++) {
            total += timeTrial(original);
        }
        return total / trials;
    }

    private static int[] generateRandom(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = StdRandom.uniformInt(-1000000, 1000000);
        return a;
    }

    private static int[] generateSorted(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
        return a;
    }

    private static int[] generateReversed(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = n - i;
        return a;
    }

    private static int[] generateEqual(int n) {
        int[] a = new int[n];
        Arrays.fill(a, 42);
        return a;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 4000, 16000, 64000, 256000};

        System.out.println("=== KET QUA KHAO SAT THOI GIAN CHAY CUA MERGESORT (ms) ===");
        System.out.printf("%-10s | %-12s | %-12s | %-12s | %-12s%n",
                "Kich thuoc", "Random (5 lan)", "Xuoi (3 lan)", "Nguoc (3 lan)", "Bang nhau (3 lan)");
        System.out.println("----------------------------------------------------------------------");

        for (int n : sizes) {
            double tRand = runAverage(generateRandom(n), 5);
            double tSorted = runAverage(generateSorted(n), 3);
            double tRev = runAverage(generateReversed(n), 3);
            double tEqual = runAverage(generateEqual(n), 3);

            System.out.printf("%-10d | %-12.3f | %-12.3f | %-12.3f | %-12.3f%n",
                    n, tRand, tSorted, tRev, tEqual);
        }

        String[] testFiles = {"1Kints.txt", "4Kints.txt", "8Kints.txt"};
        System.out.println("\n=== THOI GIAN CHAY TREN CAC TEP ALGS4-DATA (TB 3 lan) ===");
        for (String file : testFiles) {
            try {
                In in = new In(file);
                int[] data = in.readAllInts();
                double tFile = runAverage(data, 3);
                System.out.printf("Tep: %-12s (N = %-6d) -> Thoi gian: %.3f ms%n", file, data.length, tFile);
            } catch (Exception e) {
                System.out.println("Khong tim thay tep " + file + " (vui long kiem tra lai duong dan)");
            }
        }
    }
}
