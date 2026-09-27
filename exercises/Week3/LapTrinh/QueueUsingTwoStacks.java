import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class QueueUsingTwoStacks {

    static class CustomQueue<Item> {
        private final Stack<Item> inbox;   
        private final Stack<Item> outbox; 

        public CustomQueue() {
            inbox = new Stack<>();
            outbox = new Stack<>();
        }

        public void enqueue(Item item) {
            inbox.push(item);
        }

        private void prepareOutbox() {
            if (outbox.isEmpty()) {
                while (!inbox.isEmpty()) {
                    outbox.push(inbox.pop());
                }
            }
        }

        public Item dequeue() {
            prepareOutbox();
            return outbox.pop();
        }

        public Item peek() {
            prepareOutbox();
            return outbox.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int queriesCount = sc.nextInt();
        CustomQueue<Integer> queue = new CustomQueue<>();

        for (int i = 0; i < queriesCount; i++) {
            int commandType = sc.nextInt();

            switch (commandType) {
                case 1:
                    int val = sc.nextInt();
                    queue.enqueue(val);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
                default:
                    break;
            }
        }

        sc.close();
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