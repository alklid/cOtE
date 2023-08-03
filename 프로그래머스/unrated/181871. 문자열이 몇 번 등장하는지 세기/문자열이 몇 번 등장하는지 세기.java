class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        int loop = myString.length() - pat.length() + 1;
        for (int i=0; i<loop; i++) {
            int lastIdx = i+pat.length();
            String subStr = myString.substring(i, lastIdx);
            if (subStr.equals(pat)) {
                answer++;        
            }
        }
        
        return answer;
    }
}