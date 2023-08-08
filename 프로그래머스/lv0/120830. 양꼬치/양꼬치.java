class Solution {
    public int solution(int n, int k) {
        int drink = ((k - n/10) < 0) ? 0 : (k - n/10);
        int answer = (n * 12000) + (drink * 2000);
        return answer;
    }
}