import java.util.Arrays;

class Solution {
    // 상, 하, 좌, 우, 상좌, 상우, 하좌, 하우
    private static int[] dx = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dy = new int[]{0, 0, -1, 1, -1, 1, -1, 1};
    
    public int solution(int[][] board) {
        for (int x=0; x<board.length; x++) {
            for (int y=0; y<board[0].length; y++) {
                if (board[x][y] == 1) {
                    markingNotSafe(board, x, y);
                }
            }
        }
        
        return (int)Arrays.stream(board).flatMapToInt(Arrays::stream).filter(v -> v == 0).count();
    }
    
    public void markingNotSafe(int[][] board, int x, int y) {
        for (int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx > board.length-1 || ny < 0 || ny > board.length-1 || board[nx][ny] == 1) {
                continue;
            }
            
            board[nx][ny] = 2;
        }
    }
}