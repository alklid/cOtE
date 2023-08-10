import java.util.Arrays;

class Solution {
    public int solution(int[][] lines) {
        int[] mark = new int[200];
        
        for (int[] line : lines) {
            for (int i=line[0]; i<line[1]; i++) {
                mark[i+100]++;
            }
        }
        
        return (int) Arrays.stream(mark).filter(v -> v >= 2).count();
    }
}