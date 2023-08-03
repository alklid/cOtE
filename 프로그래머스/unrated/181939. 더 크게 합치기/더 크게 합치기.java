class Solution {
    public int solution(int a, int b) {
        validation(a, b);
        
        int concat = Integer.valueOf(Integer.toString(a) + Integer.toString(b));
        int reverse = Integer.valueOf(Integer.toString(b) + Integer.toString(a));
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