import java.util.Arrays;

class Solution {
    public String[] solution(String myString) {
        int startIndex = myString.indexOf("x");
        if (startIndex == 0) {
            myString = myString.substring(startIndex+1);
        }
        
        String[] answer = myString.replaceAll("(x{2,})", "x").split("x");
        Arrays.sort(answer);
        return answer;
    }
}