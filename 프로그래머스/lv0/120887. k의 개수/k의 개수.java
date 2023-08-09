class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String search = String.valueOf(k);
        for (int x=i; x<=j; x++) {
            String s = String.valueOf(x);
            answer += s.length() - s.replace(search, "").length();
        }
        return answer;
    }
}