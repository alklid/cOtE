import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        /*
        Arrays.sort(num_list);
        int[] answer = Arrays.copyOfRange(num_list, 5, num_list.length);
        */
        
        int[] answer = Arrays.stream(num_list).sorted().skip(5).toArray();
        return answer;
    }
}