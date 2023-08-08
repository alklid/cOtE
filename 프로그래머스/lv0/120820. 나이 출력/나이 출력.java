class Solution {
    public int solution(int age) {
        int answer = -1;
        if (age > 0 && age <= 120) {
            answer = 2022 - age + 1;
        }
        return answer;
    }
}