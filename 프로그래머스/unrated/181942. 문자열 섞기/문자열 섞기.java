class Solution {
    public String solution(String str1, String str2) {
        validation(str1, str2);
        
        String answer = "";
        
        int len = str1.length();
        for (int i=0; i<len; i++) {
            answer += str1.charAt(i);
            answer += str2.charAt(i);
        }
        
        return answer;
    }
    
    static void validation(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();
        
        if (str1Len != str2Len) {
            // bad input
        }
        
        if (str1Len < 1 || str1Len > 10) {
            // bad input
        }
    }
}