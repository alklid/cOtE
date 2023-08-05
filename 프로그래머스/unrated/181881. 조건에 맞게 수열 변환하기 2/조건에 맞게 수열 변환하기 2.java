import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int[] prev = Arrays.copyOf(arr, arr.length);
        
        while (true) {
            int[] convert = Arrays.stream(prev).map(i ->
                (i >= 50 && i % 2 == 0) ? i / 2 :
                (i < 50 && i % 2 == 1) ? (i * 2) + 1 : i
            ).toArray();
            
            if (Arrays.equals(prev, convert)) {
                break;
            }
            
            prev = Arrays.copyOf(convert, convert.length);
            answer++;
        }
        
        return answer;
        
    }
}