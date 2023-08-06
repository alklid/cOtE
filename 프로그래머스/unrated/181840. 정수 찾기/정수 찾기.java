import java.util.Arrays;

class Solution {
    public int solution(int[] num_list, int n) {
        int answer = Arrays.stream(num_list)
                        .filter(num -> num == n)
                        .map(num -> 1)
                        .findFirst()
                        .orElse(0);
        return answer;
    }
}