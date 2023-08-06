import java.lang.Math;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        // 둘다 짝수
        if (a % 2 == 0 && b % 2 == 0) {
            answer = Math.abs(a - b);
        }
        
        // 둘다 홀수
        else if (a % 2 != 0 && b % 2 != 0) {
            answer = (a*a) + (b*b);
        }
        
        // 하나만 홀수
        else {
            answer = 2 * (a + b);            
        }
        
        return answer;
    }
}