class Solution {
    public int solution(int a, int b) {
        validation(a, b);
        
        int concat = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int calc = 2 * a * b;
        
        int answer = (concat >= calc) ? concat : calc;
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