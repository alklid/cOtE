package alklid.algorithm.study.stack;

import java.util.Stack;

/**
 * Stack 을 정렬하는 함수를 만드시오.
 * 단, 하나의 Stack 을 추가로 사용할 수 있고,
 * Array 등 다른 데이터 구조는 사용할 수 없음.
 *
 * A Stack | B Stack(임시)
 * A 에서 pop() 해서, B 에 넣을때 b.peek() 해서
 *   - 자기보다 작으면 B 에 넣고
 *   - 자기보다 큰것들은 다시 A 에 넣음
 */

public class StackSort {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(5);
        s1.push(1);
        s1.push(6);
        sort(s1);

        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
    }

    private static void sort(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            int tmp = s1.pop();
            while (!s2.isEmpty() && s2.peek() > tmp) {
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}
