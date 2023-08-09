import java.util.*;

class Solution {
    public int solution(String before, String after) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : before.split("")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        int answer = 1;
        int afterLen = after.length();
        for (String s : map.keySet()) {
            after = after.replace(s, "");
            afterLen -= map.get(s);
            if (after.length() != afterLen) {
                answer = 0;
                break;
            }
        }
        
        return answer;
    }
}