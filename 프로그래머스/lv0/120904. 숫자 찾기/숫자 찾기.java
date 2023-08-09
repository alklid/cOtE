class Solution {
    public int solution(int num, int k) {
        int idx = String.valueOf(num).indexOf(String.valueOf(k));
        return (idx == -1) ? -1 : idx+1;
    }
}