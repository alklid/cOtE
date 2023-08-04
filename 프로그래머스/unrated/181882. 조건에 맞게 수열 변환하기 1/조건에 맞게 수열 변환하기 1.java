class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        
        int[] answer = new int[len];
        for (int i=0; i<len; i++) {
            int val = convert(arr[i]);
            answer[i] = val;
        }
        
        return answer;
    }
    
    static int convert(int input) {
        if (input >= 50 && input % 2 == 0) {
            // 2로 나누기
            return input / 2;
        }
        
        if (input < 50 && input % 2 == 1) {
            // 2로 곱하기
            return input * 2;
        }
        
        return input;
    }
}