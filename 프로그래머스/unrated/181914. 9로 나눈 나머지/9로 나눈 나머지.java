class Solution {
    public int solution(String number) {
        char[] numbers = number.toCharArray();
        
        int sum = 0;
        for (char num : numbers) {
            sum += num - '0';    
        }
        
        int answer = sum % 9;
        return answer;
    }
}