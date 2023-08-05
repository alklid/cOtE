class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        char[] chars = my_string.toCharArray();
        for (char ch : chars) {
            int idx = ch - 'A';

            if (Character.isLowerCase(ch)) {
                idx -= 6;
            }
            
            answer[idx]++;
        }
        
        return answer;
    }
}