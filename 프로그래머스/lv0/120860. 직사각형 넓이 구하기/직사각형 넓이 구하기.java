class Solution {
    public int solution(int[][] dots) {
        // {min, max}
        int[] x = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] y = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        
        for (int[] dot : dots) {
            x[0] = Math.min(dot[0], x[0]);
            x[1] = Math.max(dot[0], x[1]);
            y[0] = Math.min(dot[1], y[0]);
            y[1] = Math.max(dot[1], y[1]);
        }
        
        return (x[1] - x[0]) * (y[1] - y[0]);
    }
}