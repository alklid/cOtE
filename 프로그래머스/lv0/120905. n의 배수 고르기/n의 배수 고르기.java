import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] answer = IntStream.of(numlist).filter(i -> i % n == 0).toArray();
        return answer;
    }
}