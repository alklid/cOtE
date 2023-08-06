import java.lang.Math;

class Solution {
    public int solution(int a, int b, int c) {
        int exponent = 1;
        int answer = a + b + c;
        
        exponent = 2;
        if (a == b || a == c || b == c) {
            answer *= pow(a,b,c,exponent);
        }
        
        exponent = 3;
        if (a == b && b == c) {
            answer *= pow(a,b,c,exponent);
        }
        
        return answer;
    }
    
    private int pow(int a, int b, int c, int exponent) {
        return (int) (Math.pow(a, exponent) + Math.pow(b, exponent) + Math.pow(c, exponent));
    }
}