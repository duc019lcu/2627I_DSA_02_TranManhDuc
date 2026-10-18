package exercises.Week6.LapTrinh;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JesseAndCookies {

    public static int cookies(int k, PriorityQueue<Integer> pq) {
        int operations = 0;

        while (!pq.isEmpty() && pq.peek() < k) {
            if (pq.size() < 2) {
                return -1;
            }

            int m1 = pq.poll(); 
            int m2 = pq.poll(); 

            int newSweetness = m1 + 2 * m2;
            pq.add(newSweetness);
            operations++;
        }

        return operations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            pq.add(scanner.nextInt());
        }

        System.out.println(cookies(k, pq));
        scanner.close();
    }
}