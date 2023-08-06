class Solution {
    public String solution(int[] numLog) {
        StringBuffer command = new StringBuffer();
        
        for (int i=1; i<numLog.length; i++) {
            int calc = numLog[i] - numLog[i-1];
            switch (calc) {
                case 1:
                    command.append("w");
                    break;
                case -1:
                    command.append("s");
                    break;
                case 10:
                    command.append("d");
                    break;
                case -10:
                    command.append("a");
                    break;
                default:
                    break;
            }
        }
        
        String answer = command.toString();
        return answer;
    }
}