import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        return String.join("", Arrays.stream(my_string.split("")).map(s -> s.toLowerCase()).sorted().toArray(String[]::new));
    }
}