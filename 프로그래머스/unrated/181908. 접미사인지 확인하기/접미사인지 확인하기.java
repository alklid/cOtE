class Solution {
    public int solution(String my_string, String is_suffix) {
        validation(my_string, is_suffix);
        
        int answer = (my_string.endsWith(is_suffix)) ? 1 : 0;
        return answer;
    }
    
    static void validation(String my_string, String is_suffix) {
        int strLen = my_string.length();
        if (strLen < 1 || strLen > 100) {
            // bad input, throw exception
        }
        
        int suffixLen = is_suffix.length();
        if (suffixLen < 1 || suffixLen > 100) {
            // bad input, throw exception
        }
        
        if (!my_string.matches("^[a-z]$")) {
            // bad input, throw exception
        }
        
        if (!is_suffix.matches("^[a-z]$")) {
            // bad input, throw exception
        }
    }
}