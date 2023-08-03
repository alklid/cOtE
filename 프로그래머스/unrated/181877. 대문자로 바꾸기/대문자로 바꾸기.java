import java.util.regex.Pattern;

class Solution {
    public String solution(String myString) {
        String answer = myString.toUpperCase();
        return answer;
    }
    
    static void validation(String input) {
        int len = input.length();
        if (len < 1 || len > 100000) {
            System.out.println("exception");
        }
        
        if (!Pattern.matches("^[a-zA-Z]*$", input)) {
            System.out.println("exception");
        }
    }
}