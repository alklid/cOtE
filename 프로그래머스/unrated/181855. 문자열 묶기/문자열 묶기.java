import java.util.Arrays;

class Solution {
    public int solution(String[] strArr) {
        int[] count = new int[30];
        
        for (String str : strArr) {
            int len = str.length();
            count[len-1]++;
        }
        
        Arrays.sort(count);
        
        int answer = count[count.length-1];
        return answer;
    }
}