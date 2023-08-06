import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = Arrays.copyOf(arr, arr.length);
        
        for (int i=0; i<query.length; i++) {
            int pos = query[i];
            
            // 짝수, 뒷부분 자르기
            if (i % 2 == 0) {
                answer = Arrays.copyOfRange(answer, 0, pos+1);
            }
            
            // 홀수, 앞부분 자르기
            else {
                answer = Arrays.copyOfRange(answer, pos, answer.length);
            }
        }
        
        return answer;
    }
}