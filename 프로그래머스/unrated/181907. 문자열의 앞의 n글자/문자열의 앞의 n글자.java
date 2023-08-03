class Solution {
    public String solution(String my_string, int n) {
        validation(my_string, n);
        
        String answer = my_string.substring(0, n);
        return answer;
    }
    
    static void validation(String my_string, int n) {
        int len = my_string.length();
        if (len < 1 || len > 1000) {
            // bad input, throw exception
        }
        
        if (n < 1 || n > len) {
            // bad input, throw exception
        }
        
        if (!my_string.matches("^[a-zA-Z0-9]$")) {
            // bad input, throw exception
        }
    }
    
}