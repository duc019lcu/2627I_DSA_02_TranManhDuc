import java.util.Scanner;

public class InsertionSortPart1 {

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : " "));
        }
        System.out.println();
    }

    public static void insertIntoSorted(int[] arr) {
        int n = arr.length;
        int target = arr[n - 1]; 
        int i = n - 2;

        while (i >= 0 && arr[i] > target) {
            arr[i + 1] = arr[i]; 
            printArray(arr);      
            i--;
        }

        arr[i + 1] = target;
        printArray(arr); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int s = sc.nextInt();
        int[] arr = new int[s];
        for (int i = 0; i < s; i++) {
            arr[i] = sc.nextInt();
        }

        insertIntoSorted(arr);
        sc.close();
    }
}