class Solution {
    public String solution(String[] arr) {
        validation(arr);
        
        String answer = "";
        
        int len = arr.length;
        for (int i=0; i<len; i++) {
            answer += arr[i];
        }
        
        return answer;
    }
    
    static void validation(String[] arr) {
        int len = arr.length;
        if (len < 1 || len > 200) {
            // bad input, throw exception
        }
        
        for (int i=0; i<len; i++) {
            if (!Character.isLowerCase(arr[i].charAt(0))) {
                // bad input, throw exception
                break;
            }
        }
    }
}