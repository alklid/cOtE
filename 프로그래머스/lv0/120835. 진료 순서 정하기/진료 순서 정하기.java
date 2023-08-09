class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        for (int i=0; i<emergency.length; i++) {
            for (int j=0; j<emergency.length; j++) {
                if (i == 0) {
                    answer[j] = 1;
                }
                if (i == j) {
                    continue;
                }
                if (emergency[i] > emergency[j]) {
                    answer[j]++;
                }
            }
        }
        
        return answer;
    }
}