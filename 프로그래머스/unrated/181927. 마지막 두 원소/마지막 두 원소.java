import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int lastVal = num_list[num_list.length-1];
        int prevLastVal = num_list[num_list.length-2];
        
        int newVal = (lastVal > prevLastVal) ? lastVal - prevLastVal : lastVal * 2;
        int[] answer = Arrays.copyOf(num_list, num_list.length+1);
        answer[answer.length-1] = newVal;
        return answer;
    }
}