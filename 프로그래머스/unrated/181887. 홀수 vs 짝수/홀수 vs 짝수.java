class Solution {
    public int solution(int[] num_list) {
        int len = num_list.length;
        
        int oddSum = 0;
        int evenSum = 0;
        for (int i=0; i<len; i++) {
            if ((i+1) % 2 != 0) {
                oddSum += num_list[i];
            }
            else {
                evenSum += num_list[i];
            }
        }
        
        int answer = (oddSum >= evenSum) ? oddSum : evenSum;
        return answer;
    }
}