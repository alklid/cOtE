import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, -1);
        
        for (int i=0; i<queries.length; i++) {
            int[] query = queries[i];
        
            int[] range = Arrays.copyOfRange(arr, query[0], query[1]+1);
            Arrays.sort(range);
            for (int j=0; j<range.length; j++) {
                if (range[j] > query[2]) {
                    answer[i] = range[j];
                    break;
                }
            }
        }
        
        return answer;
    }
}