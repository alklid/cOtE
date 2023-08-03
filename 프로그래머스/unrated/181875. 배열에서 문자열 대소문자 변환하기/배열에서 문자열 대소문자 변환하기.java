class Solution {
    public String[] solution(String[] strArr) {
        validation(strArr);
        
        int len = strArr.length;
        String[] answer = new String[len];
        for (int i=0; i<len; i++) {
            if (i % 2 == 0) {
                answer[i] = strArr[i].toLowerCase();
            }
            else {
                answer[i] = strArr[i].toUpperCase();
            }
        }
        
        return answer;
    }
    
    static void validation(String[] strArr) {
        int len = strArr.length;
        if (len < 1 || len > 20) {
            // bad input, throw exception
        }
        
        String str = String.join("", strArr);
        if (!str.matches("^[a-zA-Z]$")) {
            // bad input, throw exception
        }
    }
}