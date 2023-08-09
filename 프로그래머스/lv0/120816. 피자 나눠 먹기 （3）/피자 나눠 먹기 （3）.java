class Solution {
    public int solution(int slice, int n) {
        /*
        int answer = 1;
        while ((slice * answer) < n) {
            answer++;
        }
        return answer;
        */
        
        return (n / slice) + ((n % slice > 0) ? 1 : 0);
    }
}