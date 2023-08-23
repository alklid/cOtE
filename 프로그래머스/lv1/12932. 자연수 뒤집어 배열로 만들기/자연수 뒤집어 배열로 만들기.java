class Solution {
    public int[] solution(long n) {
        return new StringBuffer(String.valueOf(n)).reverse().chars().map(s -> s - '0').toArray();
    }
}