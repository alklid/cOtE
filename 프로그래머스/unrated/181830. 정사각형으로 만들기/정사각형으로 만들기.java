import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] arr) {
        int rowLen = arr.length;
        int colLen = arr[0].length;
        
        if (rowLen > colLen) {
            for (int i=0; i<rowLen; i++) {
                arr[i] = Arrays.copyOf(arr[i], rowLen);
            }
        }
        else {
            arr = Arrays.copyOf(arr, colLen);
            for (int i=rowLen; i<colLen; i++) {
                arr[i] = new int[colLen];
            }
        }
        
        return arr;
    }
}