import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        // 모든 합의 수 조합 구하기
        Set<Integer> nums = new HashSet<>();
        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                nums.add(numbers[i] + numbers[j]);
            }
        }

        return nums.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}