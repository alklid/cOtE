import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int len = Arrays.stream(arr).sum();
        int[] answer = new int[len];
        
        int idx = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i]; j++) {
                answer[idx] = arr[i];
                idx++;
            }
        }
        
        return answer;
    }
}