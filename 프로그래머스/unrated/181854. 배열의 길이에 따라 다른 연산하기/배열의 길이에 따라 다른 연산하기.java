class Solution {
    public int[] solution(int[] arr, int n) {
        int len = arr.length;
        for (int i=0; i<len; i++) {
            if ((len % 2 == 0 && i % 2 != 0) || (len % 2 != 0 && i % 2 == 0)) {
                arr[i] += n;
            }
        }
        return arr;
    }
}