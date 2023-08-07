import java.util.Stack;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stackList = new Stack<>();
        
        int i = 0;
        while (i < arr.length) {
            if (stackList.size() == 0) {
                stackList.push(arr[i]);
                i++;
            }
            else {
                int lastItem = stackList.peek();
                if (lastItem < arr[i]) {
                    stackList.push(arr[i]);
                    i++;
                }
                else {
                    stackList.pop();
                }
            }
        }
        
        return stackList.stream().mapToInt(num -> num).toArray();
    }
}