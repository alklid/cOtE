import java.util.Arrays;

class Solution {
    public int solution(int[] arr, int idx) {
        int[] tailArr = Arrays.copyOfRange(arr, idx, arr.length);

        int answer = -1;
        for (int i=0; i<tailArr.length; i++) {
            if (tailArr[i] == 1) {
                answer = i + idx;
                break;
            }   
        }
        return answer;
    }
}