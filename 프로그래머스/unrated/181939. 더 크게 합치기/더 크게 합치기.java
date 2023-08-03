class Solution {
    public int solution(int a, int b) {
        validation(a, b);
        
        int concat = Integer.valueOf(String.valueOf(a) + String.valueOf(b));
        int reverse = Integer.valueOf(String.valueOf(b) + String.valueOf(a));
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