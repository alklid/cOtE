package alklid.structure;

import alklid.structure.node.NodeGenericNextLinkType;

import java.util.NoSuchElementException;

/**
 * Node 구조로 Queue 구현
 */
public class QueueGenericNode<T> {

    private NodeGenericNextLinkType<T> first;
    private NodeGenericNextLinkType<T> last;

    public void add(T data) {
        NodeGenericNextLinkType<T> node = new NodeGenericNextLinkType<>(data);

        if (last != null) {
            last.next = node;
        }
        last = node;

        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T item = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return item;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        QueueGenericNode<Integer> q = new QueueGenericNode<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
    }

}
