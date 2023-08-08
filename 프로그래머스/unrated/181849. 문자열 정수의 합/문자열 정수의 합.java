import java.util.stream.Stream;
import java.lang.Character;

class Solution {
    public int solution(String num_str) {
        // int answer = Stream.of(num_str.split("")).mapToInt(i -> Integer.parseInt(i)).sum();
        int answer = num_str.chars().map(c -> Character.getNumericValue(c)).sum();
        return answer;
    }
}