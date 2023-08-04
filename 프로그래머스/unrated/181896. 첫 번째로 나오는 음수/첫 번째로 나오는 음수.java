class Solution {
    public int solution(int[] num_list) {
        int len = num_list.length;
        
        int answer = -1;
        for (int i=0; i<len; i++) {
            if (num_list[i] < 0) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}