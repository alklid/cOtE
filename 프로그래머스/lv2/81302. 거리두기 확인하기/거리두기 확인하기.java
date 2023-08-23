class Solution {
    
    // 거리 1 좌표의 방향 이동 : 위, 아래, 오른쪽, 왼쪽
    private static final int[] d1x = { 0,  0, 1, -1};
    private static final int[] d1y = {-1,  1, 0,  0};

    // 거리 2 좌표의 방향의 이동 : 위(위, 오른쪽, 왼쪽), 아래(아래, 오른쪽, 왼쪽), 오른쪽(위, 아래, 오른쪽), 왼쪽(위, 아래, 왼쪽)
    private static final int[] d2x = { 0, 1, -1,  0, 1, -1,  0,  0, 1,  0, 0, -1};
    private static final int[] d2y = {-1, 0,  0,  1, 0,  0, -1,  1, 0, -1, 1,  0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int p=0; p<places.length; p++) {
            answer[p] = 1;

            // 이차원 배열로 변경
            char[][] place = buildPlace(places[p]);

            // 거리두기 확인
            if (!isDistanced(place)) {
                answer[p] = 0;
            }
        }

        return answer;
    }
    
    private boolean isDistanced(char[][] place) {
        // 거리두기 여부 확인
        for (int y = 0; y< place.length; y++) {
            for (int x = 0; x< place[y].length; x++) {
                // 응시자가 아니면 건너뛰기
                if (place[y][x] != 'P') {
                    continue;
                }

                // 응사자 일때 거리두기 여부 확인
                if (!isDistanced(place, y, x)) {
                    return false;
                };
            }
        }

        return true;
    }

    // 거리 1 에서의 거리두기 확인
    private boolean isDistanced(char[][] place, int y, int x) {
        // 거리 1 좌표의 이동
        for (int i=0; i<d1x.length; i++) {
            int ny = d1y[i] + y;
            int nx = d1x[i] + x;

            // 더 이상 이동할 수 없으면 넘어감
            if (ny == place.length || nx == place.length || ny == -1 || nx == -1 || !isValidPlace(place[y][x])) {
                continue;
            }

            // 만약 P(응시자)가 있으면 거리두기 실패
            if (place[ny][nx] == 'P') {
                return false;
            }

            // 만약 X(파티션)이 있으면 거리 2 좌표까지 보지 않아도 됨
            if (place[ny][nx] == 'X') {
                continue;
            }

            // 만약 O(빈 테이블)이 있으면 거리 2 좌표까지 확인 필요
            if (place[ny][nx] == 'O') {
                if (!isDistanced(place, i, ny, nx)) {
                    return false;
                }
            }
        }

        return true;
    }

    // 빈 테이블 기준으로 거리 2 에서의 거리두기 확인
    private boolean isDistanced(char[][] place, int d1, int y, int x) {
        // 거리 2 좌표의 이동
        for (int i = (d1 * 3); i<(d1 * 3) + 3; i++) {
            int nx = d2x[i] + x;
            int ny = d2y[i] + y;

            // 더 이상 이동할 수 없으면 넘어감
            if (nx == place.length || ny == place.length || nx == -1 || ny == -1 || !isValidPlace(place[y][x])) {
                continue;
            }

            // 만약 P(응시자)가 있으면 거리두기 실패
            if (place[ny][nx] == 'P') {
                return false;
            }
        }

        return true;
    }

    private boolean isValidPlace(char s) {
        if (s == 'P' || s == 'O' || s == 'X') {
            return true;
        }

        return false;
    }

    private char[][] buildPlace(String[] placeText) {
        char[][] place = new char[placeText.length][placeText.length];

        for (int i=0; i<placeText.length; i++) {
            char[] arr = placeText[i].toCharArray();
            for (int j=0; j<arr.length; j++) {
                place[i][j] = arr[j];
            }
        }

        return place;
    }
}