class Solution {
    public int solution(int n) {
        int answer = 1;
        
        int val = n;
        while (true) {
            val /= answer;
            if (val <= answer) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
}