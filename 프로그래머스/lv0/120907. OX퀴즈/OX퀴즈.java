import java.util.Arrays;

class Solution {
    public String[] solution(String[] quiz) {
        return Arrays.stream(quiz).map(q -> isRight(q)).toArray(String[]::new);
    }
    
    public String isRight(String quiz) {
        String[] arr = quiz.split(" ");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[2]);
        int z = Integer.parseInt(arr[4]);
        
        String oper = arr[1];
        if ("+".equals(oper)) {
            if (x + y == z) return "O";
        }
        if ("-".equals(oper)) {
            if (x - y == z) return "O";
        }
        
        return "X";
    }
}