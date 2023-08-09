class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i=4; i<=n; i++) {
            if (isMatch(i)) answer++;
        }
        return answer;
    }
    
    static boolean isMatch(int n) {
        int matchCnt = 0;
        for (int i=1; i<=n; i++) {
            if (n % i == 0) {
                matchCnt++;
            }
            if (matchCnt == 3) {
                return true;
            }
        }
        
        return false;
    }
}