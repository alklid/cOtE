import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        int[] nums = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        // 순열 만들기
        Set<Integer> perm = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            permutation(nums, result, visited, 0, i+1, perm);
        }

        // 조합 만들기
        Set<Integer> comb = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            combination(nums, visited, 0, 0, i+1, comb);
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
    // n 개의 값 중에서 r 개의 숫자를 순서를 고려해서 뽑는 경우
    // [1, 2, 3]과 [1, 3, 2]는 다른 것으로 처리하는 경우
    private void permutation(int[] nums, int[] result, boolean[] visited, int depth, int r, Set<Integer> perm) {
        if (depth == r) {
            StringBuffer sb = new StringBuffer();
            for (int i=0; i<r; i++) {
                sb.append(result[i]);
            }
            perm.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = nums[i];
                permutation(nums, result, visited, depth + 1, r, perm);
                visited[i] = false;
            }
        }
    }

    // 조합 만들기
    // n 개의 값 중에서 r 개의 숫자를 순서를 고려하지 않고 뽑는 경우
    // [1, 2, 3]과 [1, 3, 2]는 같은 것으로 처리하는 경우
    private void combination(int[] nums, boolean[] visited, int start, int depth, int r, Set<Integer> comb) {
        if (depth == r) {
            StringBuffer sb = new StringBuffer();
            for (int i=0; i<nums.length; i++) {
                if (visited[i]) sb.append(nums[i]);
            }
            comb.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(nums, visited, i+1, depth + 1, r, comb);
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