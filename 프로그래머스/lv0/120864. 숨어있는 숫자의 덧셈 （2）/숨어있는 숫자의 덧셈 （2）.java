import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        return Arrays.stream(my_string.split("[a-zA-Z]")).filter(s -> !s.isEmpty()).mapToInt(i -> Integer.valueOf(i)).sum();
    }
}