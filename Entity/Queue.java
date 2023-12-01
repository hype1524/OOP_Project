import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    public Queue() {
        first = null;
        last = null;
        n = 0;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public int size() {
        return n;
    }
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue empty!");
        }
        return first.item;
    }
    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue empty!");
        }
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (Item item : this) {
            s.append(item);
            s.append(", ");
        }
        s.deleteCharAt(s.length() - 1);
        s.deleteCharAt(s.length() - 1);
        s.append("]");
        return s.toString();
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
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
