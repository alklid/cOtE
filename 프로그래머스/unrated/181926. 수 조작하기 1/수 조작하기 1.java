class Solution {
    public int solution(int n, String control) {
        char[] commands = control.toCharArray();
        
        int answer = n;
        for (char command : commands) {
            switch (command) {
                case 'w':
                    answer += 1;
                    break;
                case 's':
                    answer -= 1;
                    break;
                case 'd':
                    answer += 10;
                    break;
                case 'a':
                    answer -= 10;
                    break;
                default:
                    answer += 0;
                    break;
            }
        }
        
        return answer;
    }
}