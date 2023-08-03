class Solution {
    public String solution(String myString) {
        validation(myString);
        
        String answer = myString.toLowerCase();
        return answer;
    }
    
    static void validation(String input) {
        int len = input.length();
        if (len < 1 || len > 100000) {
            // bad input, throw exception
        }
    }
}