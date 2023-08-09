import java.util.Arrays;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        for(int i=0; i<num_list.length/n; i++) {
            answer[i] = Arrays.copyOfRange(num_list, i*n, i*n+n);
        }
        return answer;
    }
}