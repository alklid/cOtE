import java.util.stream.IntStream;
import java.lang.Integer;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        /*
        if (arr2.length == arr1.length) {
            int arr1Sum = IntStream.of(arr1).sum();
            int arr2Sum = IntStream.of(arr2).sum();

            return arr1Sum > arr2Sum ? 1 : arr1Sum == arr2Sum ? 0 : -1;
        }

        return arr1.length > arr2.length ? 1 : -1;
        */
        
        int answer = Integer.compare(arr1.length, arr2.length);
        if (answer == 0) {
            answer = Integer.compare(IntStream.of(arr1).sum(), IntStream.of(arr2).sum());
        }
        
        return answer;
        
    }
}