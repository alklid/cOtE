class Solution {
    public int solution(int order) {
        String orderStr = String.valueOf(order);
        int answer = orderStr.length() - orderStr.replaceAll("[369]", "").length();
        return answer;
    }
}