import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        for (int h=citations.length; h>0 ; h--) {
            System.out.println(h);

            int hIndex = h;
            int citationCount = (int) Arrays.stream(citations).filter(v -> v >= hIndex).count();

            if (citationCount >= hIndex) {
                answer = hIndex;
                break;
            }
        }
        return answer;
    }
}