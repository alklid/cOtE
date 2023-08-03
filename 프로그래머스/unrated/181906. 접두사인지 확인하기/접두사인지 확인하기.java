class Solution {
    public int solution(String my_string, String is_prefix) {
        validation(my_string, is_prefix);
        
        int answer = (my_string.startsWith(is_prefix)) ? 1 : 0;
        return answer;
    }
    
    static void validation(String my_string, String is_prefix) {
        int strLen = my_string.length();
        if (strLen < 1 || strLen > 100) {
            // bad input, throw exception
        }
        
        int prefixLen = is_prefix.length();
        if (prefixLen < 1 || prefixLen > 100) {
            // bad input, throw exception
        }
        
        if (!my_string.matches("^[a-z]*$")) {
            // bad input, throw exception
        }
        
        if (!is_prefix.matches("^[a-z]*$")) {
            // bad input, throw exception
        }
    }
}