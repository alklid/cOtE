import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1) {
            map.put(s, 1);
        }
        
        for (String s : s2) {
            answer += map.getOrDefault(s, 0);
        }
        
        return answer;
    }
}