import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = Arrays.stream(numbers).map(i -> i * 2).toArray();
        return answer;
    }
}