package alklid.algorithm.study.stack;


import alklid.structure.StackGenericNode;

class NodeWithMin {
    public int value;
    public int min;

    public NodeWithMin(int value, int min) {
        this.value = value;
        this.min = min;
    }
}

class SearchSolution1 extends StackGenericNode<NodeWithMin> {
    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        else {
            return peek().min;
        }
    }

    public void push(int value) {
        int min = Math.min(min(), value);
        NodeWithMin node = new NodeWithMin(value, min);
        super.push(node);
    }
}

class SearchSolution2 extends StackGenericNode<Integer> {
    StackGenericNode<Integer> minStack;

    public SearchSolution2() {
        minStack = new StackGenericNode<>();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        else {
            return minStack.peek();
        }
    }

    @Override
    public void push(Integer data) {
        if (data < min()) {
            minStack.push(data);
        }
        super.push(data);
    }

    @Override
    public Integer pop() {
        int value = super.pop();
        if (min() == value) {
            minStack.pop();
        }
        return value;
    }

}


/**
 * 현재 Stack 에 저장된 값중에 가장 작은 값을 확인
 */
public class StackMinSearch {

    public static void main(String[] args) {
        /**
         * O(1)의 복잡도
         * Min 값을 같이 저장하는 Node 클래스를 Stack 에 사용.
         * Stack 에 저장할때 이전에 저장된 최소값과 현재 값중에 작은 값을 min 에 항상 같이 보관.
         * val min
         * 2    1
         * 1    1
         * 5    3
         * 3    3
         */
        SearchSolution1 stack1 = new SearchSolution1();
        stack1.push(3);
        stack1.push(5);
        stack1.push(1);
        stack1.push(2);

        System.out.println("min: " + stack1.min());
        System.out.println(stack1.pop().value);
        System.out.println(stack1.pop().value);
        System.out.println("min: " + stack1.min());

        System.out.println("---------------------");

        /**
         * O(1)의 복잡도
         * Min 값을 별도로 다른 Stack 에 저장해놓고 사용.
         * val min
         * 2
         * 1
         * 5    1
         * 3    3
         */
        SearchSolution2 stack2 = new SearchSolution2();
        stack2.push(3);
        stack2.push(5);
        stack2.push(1);
        stack2.push(2);

        System.out.println("min: " + stack2.min());
        System.out.println(stack2.pop());
        System.out.println("min: " + stack2.min());
        System.out.println(stack2.pop());
        System.out.println("min: " + stack2.min());
        System.out.println(stack2.pop());
        System.out.println("min: " + stack2.min());
    }

}
