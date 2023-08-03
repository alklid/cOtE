import java.util.stream.Stream;

class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = Stream.of(strArr).filter(s -> !s.contains("ad")).toArray(String[]::new);
        return answer;
    }
}