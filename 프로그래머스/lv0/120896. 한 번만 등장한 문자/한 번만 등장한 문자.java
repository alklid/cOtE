import java.util.*;

class Solution {
    public String solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (String x : s.split("")) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        int len = (int)map.values().stream().filter(i -> i == 1).count();
        String[] only = new String[len];
        
        int idx = 0;
        for (String k : map.keySet()) {
            if (map.get(k) == 1) {
                only[idx] = k;
                idx++;
            }
        }
        Arrays.sort(only);
        
        return String.join("", only);
    }
}