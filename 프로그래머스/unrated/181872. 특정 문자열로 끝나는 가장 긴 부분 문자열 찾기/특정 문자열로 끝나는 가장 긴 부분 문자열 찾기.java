class Solution {
    public String solution(String myString, String pat) {
        int lastIndex = myString.lastIndexOf(pat);
        
        String answer = myString.substring(0, lastIndex + pat.length());
        return answer;
    }
}