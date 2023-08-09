class Solution {
    public String solution(String cipher, int code) {
        StringBuffer sb = new StringBuffer();
        char[] arr = cipher.toCharArray();
        for (int i=code-1; i<arr.length; i=i+code) {
            sb.append(arr[i]);
        }
        String answer = sb.toString();
        return answer;
    }
}