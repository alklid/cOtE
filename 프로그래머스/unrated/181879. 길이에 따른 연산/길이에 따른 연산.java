import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        int len = num_list.length;
        
        int answer = 0;
        if (len >= 11) {
            // 모든 원소의 합
            answer = Arrays.stream(num_list).sum();
        }
        else {
            // 모든 원소의 곱
            answer = 1;
            for (int i=0; i<len; i++) {
                answer *= num_list[i];
            }
        }
        
        return answer;
    }
}