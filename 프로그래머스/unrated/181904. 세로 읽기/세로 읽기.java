class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuffer sb = new StringBuffer();
        
        int loop = my_string.length() / m;
        for (int i=0; i<loop; i++) {
            int startIdx = m * i;
            sb.append(my_string.substring(startIdx, startIdx+m).charAt(c-1));
        }
        String answer = sb.toString();
        return answer;
    }
}