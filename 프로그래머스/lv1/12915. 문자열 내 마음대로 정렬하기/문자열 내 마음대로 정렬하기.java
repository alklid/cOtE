import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        // 문자열 정렬
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) != s2.charAt(n)) {
                return s1.charAt(n) - s2.charAt(n);
            }
            return s1.compareTo(s2);
        });
        return strings;
    }
}