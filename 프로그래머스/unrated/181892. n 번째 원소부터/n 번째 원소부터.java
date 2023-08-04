import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        /*
        int len = num_list.length;
        int resultLen = (len - n) + 1;
        
        int[] answer = new int[resultLen];
        for (int i=n-1; i<len; i++) {
            answer[(i-n)+1] = num_list[i];
        }
        return answer;
        */
        
        int[] answer = Arrays.copyOfRange(num_list, n-1, num_list.length);
        return answer;
    }
}