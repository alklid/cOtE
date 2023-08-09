import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] tmp = new int[numbers.length + 2];
        System.arraycopy(numbers, 0, tmp, 1, numbers.length);
        tmp[0] = numbers[numbers.length-1];
        tmp[tmp.length-1] = numbers[0];
        
        if ("right".equals(direction)) {
            return Arrays.copyOfRange(tmp, 0, numbers.length);            
        }
        
        else {
            return Arrays.copyOfRange(tmp, 2, numbers.length+2);
        }
    }
}