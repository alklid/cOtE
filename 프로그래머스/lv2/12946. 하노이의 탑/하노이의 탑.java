import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] solution(int n) {
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }
    
    private void hanoi(int n, int from, int to, List<int[]> process) {
        // 종료 조건
        if (n == 1) {
            process.add(new int[]{from, to});
            return;
        }

        // 재귀
        int empty = 6 - from - to;
        hanoi(n - 1, from, empty, process);   // n-1개의 원반을 빈 기둥으로 이동
        hanoi(1, from, to, process);          // 가장 아래 원반을 목표 기둥으로 이동
        hanoi(n - 1, empty, to, process);     // 빈 기둥으로 이동시켰던 n-1개의 원반을 목표 기둥으로 이동
    }
}