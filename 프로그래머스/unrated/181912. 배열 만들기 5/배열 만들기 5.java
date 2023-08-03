import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = Stream.of(intStrs)
                        .mapToInt(n -> Integer.valueOf(n.substring(s, s+l)))
                        .filter(n -> n > k)
                        .toArray();
        return answer;
    }
}