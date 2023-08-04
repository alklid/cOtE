class Solution {
    public int[] solution(int n, int k) {
        int len = n / k;
        int[] answer = new int[len];
        for (int i=0; i<len; i++) {
            answer[i] = k * (i+1);
        }
        return answer;
    }
}