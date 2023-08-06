import java.lang.Math;

class Solution {
    public int solution(int[][] board, int k) {
        int answer = 0;
        
        for (int i=0; i<board.length; i++) {
            if (i > k) {
                break;
            }
            
            int colLen = (k-i >= board[i].length) ? board[i].length-1 : k-i;
            for (int j=0; j<=colLen; j++) {
                answer += board[i][j];
            } 
        }
        
        return answer;
    }
}