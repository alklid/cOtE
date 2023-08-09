import java.util.*;

class Solution {
    public int solution(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : array) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        
        if (countMap.size() == 1) {
            return array[0];
        }
        
        int answer = 0;
        List<Integer> keys = new ArrayList<>(countMap.keySet());
        Collections.sort(keys, (v1, v2) -> (countMap.get(v2).compareTo(countMap.get(v1))));
        
        int firstMax = keys.get(0);
        int secondMax = keys.get(1);
        
        if (countMap.get(firstMax) == countMap.get(secondMax)) {
            answer = -1;
        }
        else {
            answer = firstMax;
        }
        
        return answer;
    }
}