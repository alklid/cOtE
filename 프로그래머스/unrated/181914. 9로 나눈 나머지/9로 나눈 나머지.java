class Solution {
    public int solution(String number) {
        /*
        char[] numbers = number.toCharArray();
        
        int sum = 0;
        for (char num : numbers) {
            sum += num - '0';    
        }
        
        int answer = sum % 9;
        return answer;
        */
        
        int answer = number.chars().map(c -> (c - '0')).sum() % 9;
        return answer;
    }
}