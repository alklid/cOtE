import java.util.stream.IntStream;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        /*
        int[] arr = new int[included.length];
        for (int i=0; i<arr.length; i++) {
            arr[i] = a + (i * d);
        }
        */
        
        /*
        int answer = 0;
        for (int i=0; i<included.length; i++) {
            if (included[i]) {
                answer += a + (i * d);
            }
        }
        */
        
        int answer = IntStream.range(0, included.length)
                        .map(idx -> included[idx] ? a + (idx * d) : 0)
                        .sum();
        return answer;
    }
}