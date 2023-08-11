class Solution {
    public int solution(int n) {
        int answer = 0;
        while (n > 0) {
            answer++;
            if (isAllowedNum(answer)) {
                n--;
            }
        }
        return answer;
    }
    
    public boolean isAllowedNum(int num) {
        if (num % 3 == 0) {
            return false;
        }
        
        if (String.valueOf(num).indexOf("3") != -1) {
            return false;
        }
        
        return true;
    }
}