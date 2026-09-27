import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Iterator;

class Result {

    public static String isBalanced(String s) {
        if (s == null || s.length() % 2 != 0) {
            return "NO";
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } 
            else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}

public class BalanceBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int numTests = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numTests; i++) {
                String input = scanner.nextLine().trim();
                System.out.println(Result.isBalanced(input));
            }
        }

        scanner.close();
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

    public boolean isEmpty() { return first == null; }
    public int size() { return n; }

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

    public Iterator<Item> iterator() { return new LinkedIterator(first); }
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;
        public LinkedIterator(Node<Item> first) { current = first; }
        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException(); }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}