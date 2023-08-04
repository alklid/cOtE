class Solution {
    public int solution(int[] numbers, int n) {
        int len = numbers.length;
        
        int answer = 0;
        for (int i=0; i<len; i++) {
            answer += numbers[i];
            if (answer > n) {
                break;
            }
        }
        
        return answer;
    }
}