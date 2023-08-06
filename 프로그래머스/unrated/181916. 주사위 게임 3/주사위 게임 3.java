import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] diceArr = new int[]{a,b,c,d};
        Map<Integer, Integer> dice = new HashMap<>();
        for (int num : diceArr) {
            dice.put(num, dice.getOrDefault(num, 0) + 1);
        }
        
        int answer = 0;
        int p = 0;
        int q = 0;
        int r = 0;
        
        // 모두 같음
        if (dice.size() == 1) {
            Map.Entry<Integer,Integer> first = dice.entrySet().iterator().next();
            p = first.getKey();
            answer = 1111 * p;
        }
        
        // 세개 같거나 쌍으로 같음
        if (dice.size() == 2) {
            Map.Entry<Integer,Integer> first = dice.entrySet().iterator().next();
            dice.remove(first.getKey());
            Map.Entry<Integer,Integer> second = dice.entrySet().iterator().next();
                        
            // 두쌍으로 같음
            if (first.getValue() == 2) {
                p = first.getKey();
                q = second.getKey();
                answer = (p + q) * Math.abs(p-q);
            }
            
            // 세개 같음
            else {
                if (first.getValue() == 3) {
                    p = first.getKey();
                    q = second.getKey();
                }
                else {
                    p = second.getKey();
                    q = first.getKey();
                }
                answer = (int)Math.pow(10 * p + q, 2);
            }
        }
        
        // 두개 같음
        if (dice.size() == 3) {
            for (Integer num : dice.keySet()) {
                if (dice.get(num) == 1 && q == 0) {
                    q = num;
                }
                if (dice.get(num) == 1 && r == 0 && num != q) {
                    r = num;
                }
                answer = q * r;
            }
        }
        
        // 모두 다름
        if (dice.size() == 4) {
            Map.Entry<Integer,Integer> first = dice.entrySet().iterator().next();
            answer = first.getKey();
        }
        
        return answer;
    }
}