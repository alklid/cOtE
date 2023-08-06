class Solution {
    public int solution(String str1, String str2) {
        int answer = (str2.indexOf(str1) == -1) ? 0 : 1;
        return answer;
    }
}