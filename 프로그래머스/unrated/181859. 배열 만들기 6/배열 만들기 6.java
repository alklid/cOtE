import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> numbers = new ArrayList<>();
        
        for (int i=0; i<arr.length; i++) {
            if (numbers.size() == 0) {
                numbers.add(arr[i]);
            }
            else {
                if (numbers.get(numbers.size()-1) == arr[i]) {
                    numbers.remove(numbers.size()-1);
                }
                else {
                    numbers.add(arr[i]);
                }
            }
        }
        
        if (numbers.size() == 0) {
            return new int[]{-1};
        }
        
        int[] answer = numbers.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}