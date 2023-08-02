class Solution {
    // 좌표의 방향 이동 : 아래, 오른쪽, 왼쪽 위
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};
    
    public int[] solution(int n) {
        // 길이, 높이가 n인 이차원 배열 생성
        int[][] triangle = new int[n][n];

        // 빈칸에 채워질 숫자
        int value = 1;

        // 좌표
        int x = 0;
        int y = 0;

        // 방향
        int d = 0;

        while (true) {
            triangle[y][x] = value++;

            // 아래로 이동
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 더 이상 진행 불가시 방향 전환
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];

                // 방향 전환을 했는데도 진행 불가시 종료
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                    break;
                }
            }

            // 전환된 방향으로 이동
            x = nx;
            y = ny;
        }

        // 채워진 배열에서 0을 제외하고 순서대로 합치기
        int[] answer = new int[value-1];
        int index = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }
}