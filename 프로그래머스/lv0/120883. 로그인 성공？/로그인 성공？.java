class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        
        for (String[] account : db) {
            if (account[0].equals(id_pw[0])) {
                answer = "wrong pw";
                
                if (account[1].equals(id_pw[1])) {
                    answer = "login";
                    break;
                }
            }
        }
        
        return answer;
    }
}