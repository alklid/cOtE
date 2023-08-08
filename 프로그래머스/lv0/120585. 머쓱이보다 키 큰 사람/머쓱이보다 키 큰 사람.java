import java.util.Arrays;

class Solution {
    public int solution(int[] array, int height) {
        int answer = (int)Arrays.stream(array).filter(h -> h > height).count();
        return answer;
    }
}