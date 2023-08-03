import java.util.regex.Pattern;

class Solution {
    public String solution(String rny_string) {
        validation(rny_string);
        
        String answer = rny_string.replaceAll("m", "rn");
        return answer;
    }
    
    static void validation(String input) {
        int len = input.length();
        if (len < 1 || len > 100) {
            // bad input, throw exception
            System.out.println("exception");
        }
        
        if (!Pattern.matches("^[a-z]*$", input)) {
            // bad input, throw exception
            System.out.println("exception");
        }
    }
}