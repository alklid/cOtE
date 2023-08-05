class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for (int num : num_list) {
            answer += countToOne(num);
        }
        return answer;
    }
    
    static int countToOne(int num) {
        int count = 0;
        while (true) {
            if (num == 1) {
                break;
            }
            
            // 짝수
            if (num % 2 == 0) {
                num = num / 2;
            }
            
            // 홀수
            else {
                num = (num - 1) / 2;
            }
            
            count++;
        }
        
        return count;
    }
}