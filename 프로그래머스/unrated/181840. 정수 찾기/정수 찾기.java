import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list, int n) {
        /*
        int answer = Arrays.stream(num_list)
                        .filter(num -> num == n)
                        .map(num -> 1)
                        .findFirst()
                        .orElse(0);
        return answer;
        */
        
        /*
        int answer = 0;
        for (int num : num_list) {
            if (num == n) {
                answer = 1;
                break;
            }
        }
        
        return answer;
        */
        
        int answer = IntStream.of(num_list).anyMatch(num -> num == n) ? 1 : 0;
        return answer;
    }
}