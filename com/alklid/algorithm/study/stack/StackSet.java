package alklid.algorithm.study.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Stack 한개를 무한정 늘리지 않고, 정해진 갯수만큼 여러개의 Stack 를 사용하도록 구성
 * 여러개의 Stack 을 이어진 것처럼 활용할 수 있도록 해야 함
 */
public class StackSet {

    int capacity;
    java.util.ArrayList<Stack<Integer>> stacks = new ArrayList<>();

    // 스택 하나당 최대 갯수
    public StackSet(int capacity) {
        this.capacity = capacity;
    }


    public ArrayList<Stack<Integer>> getStacks() {
        return stacks;
    }

    public Stack<Integer> getLastStack() {
        if (stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }

    public void addStack() {
        stacks.add(new Stack<>());
    }

    public void removeLastStack() {
        stacks.remove(stacks.size() -1);
    }

    public void push(int data) {
        Stack<Integer> last = getLastStack();
        if (last == null || last.size() == capacity) {
            addStack();
            last = getLastStack();
        }
        last.push(data);
    }

    public int pop() {
        Stack<Integer> last = getLastStack();
        if (last == null || last.isEmpty()) {
            throw new EmptyStackException();
        }
        int data = last.pop();
        if (last.isEmpty()) {
            removeLastStack();
        }

        return data;
    }

    public static void main(String[] args) {
        StackSet sos = new StackSet(3);
        sos.push(1);
        sos.push(2);
        sos.push(3);

        sos.push(4);
        sos.push(5);
        sos.push(6);

        sos.push(7);
        sos.push(8);
        sos.push(9);

        sos.getStacks().forEach(s -> System.out.print(s.size() + " "));
        System.out.println();

        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        sos.getStacks().forEach(s -> System.out.print(s.size() + " "));
        System.out.println();

        System.out.println(sos.pop());
        sos.getStacks().forEach(s -> System.out.print(s.size() + " "));
        System.out.println();
    }
}
