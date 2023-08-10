class Solution {
    // up, down, left, right
    public static int[] dx = new int[]{0, 0, -1, 1};
    public static int[] dy = new int[]{1, -1, 0, 0};
    
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        
        int maxX = board[0] / 2;
        int minX = maxX * -1;
        
        int maxY = board[1] / 2;
        int minY = maxY * -1;
        
        int nx = 0;
        int ny = 0;
        
        for (String key : keyinput) {
            switch (key) {
                case "up":
                    nx += dx[0];
                    ny += ((ny + dy[0]) < minY || (ny + dy[0]) > maxY) ? 0 : dy[0];
                    break;
                case "down":
                    nx += dx[1];
                    ny += ((ny + dy[1]) < minY || (ny + dy[1]) > maxY) ? 0 : dy[1];
                    break;
                case "left":
                    nx += ((nx + dx[2]) < minX || (nx + dx[2]) > maxX) ? 0 : dx[2];
                    ny += dy[2];
                    break;
                case "right":
                    nx += ((nx + dx[3]) < minX || (nx + dx[3]) > maxX) ? 0 : dx[3];
                    ny += dy[3];
                    break;
                default:
                    break;
            }
        }
        
        int[] answer = new int[]{nx, ny};
        return answer;
    }
}