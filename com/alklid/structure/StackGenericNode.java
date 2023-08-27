package alklid.structure;

import alklid.structure.node.NodeGenericNextLinkType;

import java.util.EmptyStackException;

public class StackGenericNode<T> {

    private NodeGenericNextLinkType<T> top;

    // 추가
    public void push(T data) {
        NodeGenericNextLinkType<T> t = new NodeGenericNextLinkType<>(data);
        t.next = top;
        top = t;
    }

    // 조회
    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // 삭제
    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        StackGenericNode<Integer> s = new StackGenericNode<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }

}
