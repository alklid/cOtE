class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        int i1 = x1 ? 1 : 0;
        int i2 = x2 ? 1 : 0;
        int i3 = x3 ? 1 : 0;
        int i4 = x4 ? 1 : 0;
         
        boolean answer = (((i1 | i2) & (i3 | i4)) == 1) ? true : false;
        return answer;
    }
}