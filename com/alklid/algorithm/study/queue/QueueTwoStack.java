package alklid.algorithm.study.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 두개의 Stack 으로 하나의 Queue 를 구현
 *
 * add() 는 A Stack 에 넣고
 * peek(), remove() 이 요청되면 A 를 B 에 넣고(그럼 reverse 됨), B에서 처리
 *  - B 가 없을 때까지 B 에서 처리하고, 없으면 A 에 있는걸 다시 B 에 넣고 처리
 */

public class QueueTwoStack<T> {

    Stack<T> newStack;
    Stack<T> oldStack;

    QueueTwoStack() {
        newStack = new Stack<>();
        oldStack = new Stack<>();
    }

    public int size() {
        return newStack.size() + oldStack.size();
    }

    public void add(T value) {
        newStack.push(value);
    }

    private void shiftStack() {
        if (oldStack.empty()) {
            if (newStack.empty()) {
                throw new NoSuchElementException();
            }

            while (!newStack.empty()) {
                oldStack.push(newStack.pop());
            }
        }
    }

    public T peek() {
        shiftStack();
        return oldStack.peek();
    }

    public T remove() {
        shiftStack();
        return oldStack.pop();
    }

    public static void main(String[] args) {
        QueueTwoStack<Integer> q = new QueueTwoStack<>();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }

}
