import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        
        int len = powered(2, arr.length);
        int[] answer = Arrays.copyOf(arr, len);
        return answer;
    }
    
    static int powered(int n, int min) {
        int powered = n;
        while (powered < min) {
            powered *= n;
        }
        
        return powered;
    }
}