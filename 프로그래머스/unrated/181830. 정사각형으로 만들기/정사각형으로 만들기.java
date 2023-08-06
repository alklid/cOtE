import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] arr) {
        /*
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
        */
        
        int max = Math.max(arr.length, arr[0].length);
        int[][] answer = new int[max][max];

        for (int i = 0; i < arr.length; i++) {
            // src, srcPos, des, desPos, length
            System.arraycopy(arr[i], 0, answer[i], 0, arr[0].length);
        }
        return answer;
    }
}