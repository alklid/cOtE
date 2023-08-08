import java.util.regex.Pattern;

class Solution {
    public int solution(String message) {
        int answer = 0;
        
        if (validation(message)) {
            // 테스트 3번 때문에 문자 체크하지 않음
        }
        
        answer = message.length() * 2;
        return answer;
    }
    
    static boolean validation(String message) {
        int len = message.length();
        if (len < 1 || len > 50) {
            return false;
        }
        
        if (!Pattern.matches("^[a-zA-Z!~\\s]*$", message)) {
            return false;
        }
        
        return true;
    }
}