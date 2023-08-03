class Solution {
    public String solution(String myString) {
        String answer = myString.toUpperCase();
        return answer;
    }
    
    static void validation(String input) {
        int len = input.length();
        if (len < 1 || len > 100000) {
            // bad input, throw exception
        }
        
        if (!input.matches("^[a-zA-Z]$")) {
            // bad input, throw exception
        }
    }
}