import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int evenCount = (int)Arrays.stream(num_list).filter(i -> i%2 == 0).count();
        int[] answer = new int[]{evenCount, num_list.length - evenCount};
        return answer;
    }
}