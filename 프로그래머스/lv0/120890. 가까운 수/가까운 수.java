import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        if (array.length == 1) {
            return array[0];
        }
        
        int[] tmp = Arrays.copyOf(array, array.length+1);
        tmp[tmp.length-1] = n;
        Arrays.sort(tmp);
        
        int answer = 0;
        for (int i=0; i<tmp.length; i++) {
            if (tmp[i] == n) {
                if (i == tmp.length-1) {
                    answer = tmp[i-1];
                }
                else if (i == 0) {
                    answer = tmp[i];
                }
                else {
                    answer = (n - tmp[i-1] <= tmp[i+1] - n) ? tmp[i-1] : tmp[i+1];
                }
                break;
            }
        }
        
        return answer;
    }
}