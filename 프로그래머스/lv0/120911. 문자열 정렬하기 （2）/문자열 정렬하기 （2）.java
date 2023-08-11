import java.util.Arrays;
import java.util.Locale;

class Solution {
    public String solution(String my_string) {
        return String.join("", Arrays.stream(my_string.split("")).map(s -> s.toLowerCase(Locale.ROOT)).sorted().toArray(String[]::new));
    }
}