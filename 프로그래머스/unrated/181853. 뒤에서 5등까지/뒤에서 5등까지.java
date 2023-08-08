import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = IntStream.of(num_list).sorted().limit(5).toArray();
        return answer;
    }
}