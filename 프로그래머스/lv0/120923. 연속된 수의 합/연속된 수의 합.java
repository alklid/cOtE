import java.util.Arrays;


/**
* 연속된 숫자배열의 합이 원하는 값과 같도록
**/
class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int start = (total / num) - ((num - 1) / 2);
        for (int i=0; i<num; i++) {
            answer[i] = start + i;
        }
        
        return answer;
        
        /*
        int[] answer = new int[num];
        
        int mid = total / num;
        answer[0] = mid;
        
        for (int i=0; i<(num-1)/2; i++) {
            answer[i*2 + 1] = mid + (i+1) * -1;
            answer[i*2 + 2] = mid + (i+1);
        }
        
        // 짝수의 경우 마지막 배열에 모자란 값 추가
        if ((num-1)%2 > 0) {
            answer[num-1] = total - Arrays.stream(answer).sum();
        }

        Arrays.sort(answer);
        return answer;
        */
    }
}
