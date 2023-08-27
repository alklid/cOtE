import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        // 순열 만들기
        int[] nums = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        Set<Integer> perm = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            permutation(nums, result, visited, 0, i+1, perm);
        }

        // 경우의 수마다 isPrime 확인
        int primeCount = 0;
        for (Integer num : perm) {
            if (isPrime(num)) {
                primeCount++;
            }
        }
        return primeCount;
    }
    
    // 순열 만들기
    private void permutation(int[] nums, int[] result, boolean[] visited, int depth, int lv, Set<Integer> perm) {
        if (depth == lv) {
            StringBuffer sb = new StringBuffer();
            for (int i=0; i<lv; i++) {
                sb.append(result[i]);
            }
            perm.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = nums[i];
                permutation(nums, result, visited, depth + 1, lv, perm);
                visited[i] = false;
            }
        }
    }

    // 소수여부 확인
    private boolean isPrime(int num) {
        // 0, 1, 2는 예외처리
        if (num == 0) return false;
        if (num == 1) return false;
        if (num == 2) return true;

        // 2를 제외한 모든 짝수는 소수가 아님.
        if (num % 2 == 0) return false;

        // 2를 제외했으니, 3 이상의 모든 홀수로 제곱근을 나누어 봄. 나누어 떨어지면 소수가 아님.
        int sqrtNumber = ((Double) Math.sqrt(num)).intValue();
        for (int div = 3; div <= sqrtNumber; div += 2) {
            if (num % div == 0) return false;
        }

        return true;
    }
}