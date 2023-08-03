class Solution {
    public String[] solution(String my_string) {
        validation(my_string);
        
        String[] answer = my_string.split(" ");
        return answer;
    }
    
    static void validation(String input) {
        int len = input.length();
        if (len < 1 || len > 1000) {
            // bad input, throw exception
        }
        
        for (int i=0; i<len; i++) {
            char ch = input.charAt(i);
            if (!Character.isLowerCase(ch) && ch != ' ') {
                // bad input, throw exception
                break;
            }
        }
    }
}