/**
* 두 선이 평행하다는 것을 두 선을 이루는 각 두 점들의 x 좌표 차이와 y 좌표 차이의 비율이 같은지를 확인
* 따라서 x 좌표끼리의 차이와 y 좌표끼리의 차이중 더 큰값을 작은 값으로 나눈 몫과 나머지가 같은 지를 확인
* 예) 점 [1,4][3,8] 과 점 [8,1][12,9] 에서
*      [1,4][3,8] 직선에서 x 좌표 차이는 2, y 좌표 차이는 4 -> 따라서 비율은 몫 2, 나머지 0 으로 설정
*      [8,1][12,9] 직선에서 x 좌표 차이는 4, y 좌표 차이는 8 -> 따라서 비율은 몫 2, 나머지 0 으로 설정
*      두 선의 비율로 설정된 몫과 나머지가 같음으로 이 두 직선은 평행함.
**/
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