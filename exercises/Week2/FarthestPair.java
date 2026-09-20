package exercises.Week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FarthestPair {

    public static void findFarthestPair(double[] a) {
        if (a == null || a.length < 2) {
            throw new IllegalArgumentException("Mang phai co it nhat 2 phan tu.");
        }

        double min = a[0];
        double max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            } else if (a[i] > max) {
                max = a[i];
            }
        }

        StdOut.println("Cap xa nhat la: " + min + " va " + max);
        StdOut.println("Khoang cach toi da: " + Math.abs(max - min));
    }

    public static void main(String[] args) {
        double[] a = StdIn.readAllDoubles();
        findFarthestPair(a);
    }
}