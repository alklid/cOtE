
class Solution {
    public int[][] solution(int n) {
        // 우 -> 하 -> 좌 -> 상
        int d = 0;
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        
        int[][] answer = new int[n][n];
        int x = 0;
        int y = 0;
        int val = 1;
        
        while (true) {
            // 값 설정
            answer[y][x] = val++;
            
            // 방향 이동
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            // 더 이상 진행불가시 다음 방향으로
            if (nx == n || ny == n || nx == -1 || ny == -1 || answer[ny][nx] != 0) {
                d = (d + 1) % 4; // 다음 방향 전환
                nx = x + dx[d];
                ny = y + dy[d];

                // 방향 전환을 했는데도 진행 불가시 종료
                if (nx == n || ny == n || nx == -1 || ny == -1 || answer[ny][nx] != 0) {
                    break;
                }   
            }
            
            // 전환된 방향으로 이동
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}