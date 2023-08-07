import java.util.Stack;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n) {
        Stack<Integer> stack = new Stack<>();
        
        while (true) {
            stack.push(n);
            
            if (n == 1) {
                break;
            }
                        
            if (n % 2 == 0) {
                n = n / 2;
            }
            else {
                n = 3 * n + 1;
            }
        }
        
        int[] answer = stack.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}