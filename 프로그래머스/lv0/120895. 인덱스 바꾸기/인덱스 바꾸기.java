class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] strArr = my_string.toCharArray();
        char tmp = strArr[num1];
        strArr[num1] = strArr[num2];
        strArr[num2] = tmp;
        String answer = new String(strArr);
        return answer;
    }
}