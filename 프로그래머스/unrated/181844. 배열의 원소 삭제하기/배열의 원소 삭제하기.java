import java.util.List;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new LinkedList<>();
        for (int num : arr) {
            list.add(num);
        }
        
        for (int num : delete_list) {
            list.remove(Integer.valueOf(num));
        }
        
        int[] answer = list.stream().mapToInt(num -> num).toArray();
        return answer;
    }
}