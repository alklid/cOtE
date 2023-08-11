import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> primeFactorNumbers = factor(n);
        return primeFactorNumbers.stream().mapToInt(i -> i).distinct().toArray();
    }
    
    public List<Integer> factor(int num) {
        List<Integer> primeFactorNumbers = new ArrayList<>();

        int sqrtNumber = ((Double) Math.sqrt(num)).intValue();
        for (int div = 2; div <= sqrtNumber; div++) {
            while (num % div == 0) {
                num /= div;
                primeFactorNumbers.add(div);
            }
        }

        if (num > 1) primeFactorNumbers.add(num);
        return primeFactorNumbers;
    }
}