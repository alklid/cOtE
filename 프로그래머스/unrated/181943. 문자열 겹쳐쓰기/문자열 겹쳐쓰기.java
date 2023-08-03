class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        validation(my_string, overwrite_string, s);
        
        String my_first_string = my_string.substring(0, s);
        String my_last_string = my_string.substring(s + overwrite_string.length());
        
        String answer = my_first_string + overwrite_string + my_last_string;
        return answer;
    }
    
    static void validation(String my_string, String overwrite_string, int s) {
        // TODO check validation
        int my_string_len = my_string.length();
        int overwrite_string_len = overwrite_string.length();
        
        if (overwrite_string_len < 1 || overwrite_string_len > my_string_len) {
            // bad input
        }
        
        if (my_string_len < overwrite_string_len || my_string_len > 1000) {
            // bad input
        }
        
        if (s < 0 || s > (my_string_len - overwrite_string_len)) {
            // bad input
        }
    }
}