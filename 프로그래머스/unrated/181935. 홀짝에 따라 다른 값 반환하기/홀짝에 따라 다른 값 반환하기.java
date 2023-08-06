class Solution {
    public int solution(int n) {
        int start = 1;
        boolean even = false;
        
        // 짝수
        if (n % 2 == 0) {
            start = 2;
            even = true;
        }
        
        int answer = 0;
        for (int i=start; i<=n; i=i+2) {
            answer += (even) ? i*i : i;
        }
        
        return answer;
    }
}