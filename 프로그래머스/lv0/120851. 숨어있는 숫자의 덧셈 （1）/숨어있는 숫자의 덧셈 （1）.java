import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        String numStr = my_string.replaceAll("[a-zA-Z]", "");
        return Arrays.stream(numStr.split("")).mapToInt(s -> Integer.valueOf(s)).sum();
    }
}