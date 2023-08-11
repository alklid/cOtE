import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
            
        // 가장 긴 변이 마지막 원소인 경우
        int case1 = (int)IntStream.rangeClosed(sides[1] - sides[0] + 1, sides[1]).count();
        
        // 가장 긴 변 나머지 한 변인 경우
        int case2 = (int)IntStream.range(sides[1] + 1, sides[0] + sides[1]).count();

        return case1 + case2;
    }
}