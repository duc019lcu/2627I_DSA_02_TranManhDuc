import java.util.*;

class Result {

    private static int loadStack(List<Integer> heights, Stack<Integer> stack) {
        int total = 0;
        for (int i = heights.size() - 1; i >= 0; i--) {
            int h = heights.get(i);
            stack.push(h);
            total += h;
        }
        return total;
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        int sum1 = loadStack(h1, s1);
        int sum2 = loadStack(h2, s2);
        int sum3 = loadStack(h3, s3);

        while (sum1 != sum2 || sum2 != sum3) {
            int maxHeight = Math.max(sum1, Math.max(sum2, sum3));

            if (sum1 == maxHeight) {
                sum1 -= s1.pop();
            } else if (sum2 == maxHeight) {
                sum2 -= s2.pop();
            } else {
                sum3 -= s3.pop();
            }
        }

        return sum1;
    }
}

public class EqualStacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        List<Integer> h1 = readInput(scanner, n1);
        List<Integer> h2 = readInput(scanner, n2);
        List<Integer> h3 = readInput(scanner, n3);

        int result = Result.equalStacks(h1, h2, h3);
        System.out.println(result);

        scanner.close();
    }

    private static List<Integer> readInput(Scanner sc, int size) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(sc.nextInt());
        }
        return list;
    }
}

class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}