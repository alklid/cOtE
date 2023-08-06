class Solution {
    public int solution(int[] num_list) {
        int multi = 1;
        int sum = 0;
        
        for (int num : num_list) {
            multi *= num;
            sum += num;
        }
        
        int answer = (multi < (sum*sum)) ? 1 : 0;
        return answer;
    }
}