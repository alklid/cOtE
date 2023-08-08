import java.util.Arrays;

class Solution {
    public double solution(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        double answer = (double)sum / (double)numbers.length;
        return answer;
    }
}