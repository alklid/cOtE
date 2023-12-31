import java.util.regex.Pattern;

class Solution {
    public String solution(String my_string, String alp) {
        validation(my_string, alp);
        
        String answer = my_string.replaceAll(alp, alp.toUpperCase());
        return answer;
    }
    
    static void validation(String my_string, String alp) {
        int strLen = my_string.length();
        if (strLen < 1 || strLen > 1000) {
            System.out.println("exception");
        }
        
        if (alp.length() != 1 || !Pattern.matches("^[a-z]*$", alp)) {
            System.out.println("exception");
        }
    }
}