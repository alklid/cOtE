class Solution {
    public String[] solution(String my_str, int n) {
        int len = (my_str.length() / n) + ((my_str.length() % n == 0) ? 0 : 1);
        String[] answer = new String[len];
        for (int i=0; i<len; i++) {
            int startPos = i * n;
            int endPos = (i * n) + n;
            if (i+1 == len) {
                answer[i] = my_str.substring(startPos);
            }
            else {
                answer[i] = my_str.substring(startPos, endPos);
            }
        }
        return answer;
    }
}