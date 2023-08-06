import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> unique = new LinkedHashSet<>();
       
        for (int i=0; i<arr.length; i++) {
            unique.add(arr[i]);
            
            if (unique.size() == k) {
                break;
            }
        }
        
        int[] answer = unique.stream().mapToInt(i -> i).toArray();
        int uniqueLen = unique.size();
        if (uniqueLen < k) {
            answer = Arrays.copyOf(answer, k);
            Arrays.fill(answer, uniqueLen, k, -1);
        }
        return answer;
    }
}