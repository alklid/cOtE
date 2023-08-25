class Solution {
    public int[] solution(int[][] arr) {
        return compress(arr, 0, 0, arr.length);
    }
    
    private int[] compress(int[][] arr, int x, int y, int size) {
        int[] count = new int[2];

        // 같은 수로 채워져 있으면 return 종료
        int countZero = 0;
        int countOne = 0;
        for (int i=y; i<y+size; i++) {
            for (int j=x; j<x+size; j++) {
                if (arr[i][j] == 1) {
                    countOne++;
                }
                else {
                    countZero++;
                }
            }
        }
        if (countZero == size * size) {
            count[0] = 1;
            return count;
        }
        if (countOne == size * size) {
            count[1] = 1;
            return count;
        }

        // 채워져 있지 않으면 쪼개서 재귀 호출
        int[] first = compress(arr, x, y, size/2);
        int[] second = compress(arr, x+size/2, y, size/2);
        int[] third = compress(arr, x, y+size/2, size/2);
        int[] fourth = compress(arr, x+size/2, y+size/2, size/2);

        count[0] += first[0] + second[0] + third[0] + fourth[0];
        count[1] += first[1] + second[1] + third[1] + fourth[1];

        return count;
    }
}