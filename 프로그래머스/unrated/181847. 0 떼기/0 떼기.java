class Solution {
    public String solution(String n_str) {
        String answer = n_str;
        
        while (true) {
            if (!answer.startsWith("0")) {
                break;
            }
            answer = answer.substring(1);
        }
        
        return answer;
    }
}