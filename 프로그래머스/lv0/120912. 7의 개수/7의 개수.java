class Solution {
    public int solution(int[] array) {
        StringBuffer sb = new StringBuffer();
        for (int n : array) {
            sb.append(String.valueOf(n));
        }
        return sb.toString().length() - sb.toString().replace("7", "").length();
    }
}