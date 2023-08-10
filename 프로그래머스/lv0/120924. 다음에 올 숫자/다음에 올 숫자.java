class Solution {
    public int solution(int[] common) {
        int sum = 0;
        int multiply = 1;
        
        if (common[1] - common[0] == common[2] - common[1]) {
            sum = common[1] - common[0];
        }
        
        if (common[0] != 0 && common[1] != 0 &&
            (common[1] % common[0] == 0) && 
            (common[2] % common[1] == 0) &&
            (common[1] / common[0] == common[2] / common[1])) {
            multiply = common[1] / common[0];
        }
        
        return (sum != 0) ? common[common.length-1] + sum : common[common.length-1] * multiply;
    }
}