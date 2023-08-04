import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        int answer = (num_list.length >= 11) ? 0 : 1;
        
        if (num_list.length >= 11) {
            // 모든 원소의 합
            answer = Arrays.stream(num_list).sum();
        }
        else {
            // 모든 원소의 곱
            answer = Arrays.stream(num_list).reduce(1, (a, b) -> a * b);
        }
        
        return answer;
    }
}