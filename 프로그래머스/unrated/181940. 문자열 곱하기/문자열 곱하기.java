class Solution {
    public String solution(String my_string, int k) {
        validation(my_string, k);
        
        String answer = my_string.repeat(k);
        return answer;
    }
    
    static void validation(String str, int k) {
        int len = str.length();
        if (len < 1 || len > 100) {
            // bad input, throw exception
        }
        
        if (k < 1 || k > 100) {
            // bad input, throw exception
        }
    }
}