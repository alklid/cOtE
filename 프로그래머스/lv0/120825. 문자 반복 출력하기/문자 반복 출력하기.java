class Solution {
    public String solution(String my_string, int n) {
        StringBuffer sb = new StringBuffer();
        for (String s : my_string.split("")) {
            sb.append(s.repeat(n));
        }
        String answer = sb.toString();
        return answer;
    }
}