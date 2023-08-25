class Solution {
    
    private static class Count {
        public final int zero;
        public final int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count count) {
            return new Count(zero + count.zero, one + count.one);
        }
    }
    
    public int[] solution(int[][] arr) {
        Count count = count(arr, 0, 0, arr.length);
        return new int[]{count.zero, count.one};
    }
    
    private Count count(int[][] arr, int x, int y, int size) {
        // 같은 수로 채워져 있는지 확인
        for (int nx=x; nx<x+size; nx++) {
            for (int ny=y; ny<y+size; ny++) {
                // 만약 다른수가 나오면 해당 영역을 분리해서 다시 확인
                if (arr[ny][nx] != arr[y][x]) {
                    return count(arr, x, y, size/2)
                        .add(count(arr, x+size/2, y, size/2))
                        .add(count(arr, x, y+size/2, size/2))
                        .add(count(arr, x+size/2, y+size/2, size/2));
                }
            }
        }

        // 모두 같은 수로 채워져 있다면
        if (arr[y][x] == 1) {
            return new Count(0, 1);
        }
        else {
            return new Count(1, 0);
        }
    }
}