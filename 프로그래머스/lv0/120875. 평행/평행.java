class Solution {
    public int solution(int[][] dots) {
        // ab cd
        int[] ab = getAngle(dots[0], dots[1]);
        int[] cd = getAngle(dots[2], dots[3]);
        
        // ac - bd
        int[] ac = getAngle(dots[0], dots[2]);
        int[] bd = getAngle(dots[1], dots[3]);
        
        // ad - bc
        int[] ad = getAngle(dots[0], dots[3]);
        int[] bc = getAngle(dots[1], dots[2]);
        
        if (isParallel(ab, cd) || isParallel(ac, bd) || isParallel(ad, bc)) {
            return 1;
        }
        
        return 0;
    }
    
    public int[] getAngle(int[] a, int[] b) {
        int diffX = Math.abs(a[0] - b[0]);
        int diffY = Math.abs(a[1] - b[1]);
        
        if (diffX == 0 && diffY == 0) {
            return new int[]{0, 0};
        }
        
        return new int[]{Math.max(diffX, diffY) / Math.min(diffX, diffY), Math.max(diffX, diffY) % Math.min(diffX, diffY)};
    }
    
    public boolean isParallel(int[] first, int[] second) {
        if (first[0] == second[0] && first[1] == second[1]) {
            return true;
        }
        
        return false;
    }
}