class Solution {
    public int solution(String binomial) {
        String[] arr = binomial.split("\\s+");
        int a = Integer.valueOf(arr[0]);
        int b = Integer.valueOf(arr[2]);
        
        int answer = 0;
        
        String op = arr[1];
        switch (op) {
            case "+":
                answer = a + b;
                break;
            case "-":
                answer = a - b;
                break;
            case "*":
                answer = a * b;
                break;
            default:
                break;
        }
        
        return answer;
    }
}