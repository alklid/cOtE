class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = chicken;
        
        while(coupon / 10 > 0) {
            int service = coupon / 10;
            coupon = (coupon % 10) + service;
            answer += service;
        }
        
        return answer;
    }
}