class Solution {
    public int solution(int a, int b) {
        validation(a, b);
        
        int concat = Integer.parseInt(""+a+b);
        int reverse = Integer.parseInt(""+b+a);
        int answer = (concat >= reverse) ? concat : reverse;
        return answer;
    }
    
    static void validation(int a, int b) {
        if (a < 1 || a >= 10000) {
            // bad input, throw exception
        }
        
        if (b < 1 || b >= 10000) {
            // bad input, throw exception
        }
    }
}