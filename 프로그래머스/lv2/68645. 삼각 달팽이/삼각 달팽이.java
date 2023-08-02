class Solution {
    public int[] solution(int n) {
        // 길이, 높이가 n인 이차원 배열 생성
        int[][] triangle = new int[n][n];

        // 빈칸에 채워질 숫자
        int value = 1;

        // 좌표
        int x = 0;
        int y = 0;

        while (true) {
            // 아래로 이동
            while (true) {
                triangle[y][x] = value++;

                // 아래로 갈 수 없으면(마지막 줄이거나, 아래칸의 값이 이미 채워져 있으면) 종료
                if (y + 1 == n || triangle[y + 1][x] != 0) break;
                y++;
            }

            // 오른쪽으로 갈 수 없으면(가장 오른쪽이거나, 오른쪽의 값이 이미 채워져 있으면) 종료
            if (x + 1 == n || triangle[y][x+1] != 0) break;
            x++;

            // 오른쪽으로 이동
            while (true) {
                triangle[y][x] = value++;

                // 오른쪽으로 갈 수 없으면(가장 오른쪽이거나, 오른쪽의 값이 이미 채워져 있으면) 종료
                if (x + 1 == n || triangle[y][x+1] != 0) break;
                x++;
            }

            // 위쪽으로 갈 수 없으면(위칸의 값이 이미 채워져 있으면) 종료
            if (triangle[y-1][x-1] != 0) break;
            x--;
            y--;

            // 위로 이동
            while (true) {
                triangle[y][x] = value++;

                // 위쪽으로 갈 수 없으면(위칸의 값이 이미 채워져 있으면) 종료
                if (triangle[y-1][x-1] != 0) break;
                x--;
                y--;
            }

            // 아래로 갈 수 없으면(마지막 줄이거나, 아래칸의 값이 이미 채워져 있으면) 종료
            if (y + 1 == n || triangle[y + 1][x] != 0) break;
            y++;
        }


        // 채워진 배열에서 0을 제외하고 순서대로 합치기
        int[] answer = new int[value-1];
        int index = 0;
        for (int j=0; j<n; j++) {
            for (int i=0; i<n; i++) {
                if (triangle[j][i] > 0) {
                    answer[index++] = triangle[j][i];
                }
            }
        }

        return answer;
    }
}