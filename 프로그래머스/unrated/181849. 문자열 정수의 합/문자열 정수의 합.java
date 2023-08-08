import java.util.stream.Stream;

class Solution {
    public int solution(String num_str) {
        int answer = Stream.of(num_str.split("")).mapToInt(i -> Integer.parseInt(i)).sum();
        return answer;
    }
}