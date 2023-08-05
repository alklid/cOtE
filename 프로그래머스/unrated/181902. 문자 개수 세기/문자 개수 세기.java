class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        char[] chars = my_string.toCharArray();
        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                int idx = ch - 65;
                answer[idx]++;
            }
            if (Character.isLowerCase(ch)) {
                int idx = ch - 71;
                answer[idx]++;
            }
        }
        
        return answer;
    }
}