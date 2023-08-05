import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        int[] answer = {};
        
        for (int i=0; i<flag.length; i++) {
            if (flag[i] == true) {
                answer = addArray(answer, arr, i);
            }
            else {
                answer = deleteArray(answer, arr, i);
            }

        }
        
        return answer;
    }
    
    static int[] addArray(int[] answer, int[] arr, int idx) {
        // 기존 배열에 arr[idx] 값의 두배만큼 arr[idx] 값으로 채우기
        int originLen = answer.length;
        int len = originLen + (arr[idx] * 2);
        answer = Arrays.copyOf(answer, len);
        Arrays.fill(answer, originLen, len, arr[idx]);
        
        return answer;
    }
    
    static int[] deleteArray(int[] answer, int[] arr, int idx) {
        // idx 만큼 뒤에서 자르기
        int len = answer.length - arr[idx];
        answer = Arrays.copyOf(answer, len);
        
        return answer;
    }
}