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
        }
        
        if (!input.matches("^[a-z]$")) {
            // bad input, throw exception
        }
    }
}