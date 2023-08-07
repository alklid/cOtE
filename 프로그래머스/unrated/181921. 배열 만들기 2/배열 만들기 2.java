import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int l, int r) {
        int[] target = buildArr(new int[]{0,5}, 1, 1000000);
        int[] answer = IntStream.of(target).filter(num -> num >= l && num <= r).toArray();
        if (answer.length == 0) {
            return new int[]{-1};
        }
        return answer;
    }
    
    private int[] buildArr(int[] arr, int exponent, int max) {
        if (5 * Math.pow(10, exponent) > max) {
            return arr;
        }
        
        int[] newArr = Arrays.copyOf(arr, arr.length*2);
        for (int i=0; i<arr.length; i++) {
            newArr[i+arr.length] = (int)(arr[i] + (5 * Math.pow(10, exponent)));
        }
        exponent++;
        
        return buildArr(newArr, exponent, max);
    }
}