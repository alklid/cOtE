class Solution {
    public String solution(int q, int r, String code) {
        StringBuffer sb = new StringBuffer();
        
        for (int i=0; i<code.length(); i++) {
            int val = i % q;
            if (val == r) {
                sb.append(code.charAt(i));
            }
        }
        String answer = sb.toString();
        return answer;
    }
}