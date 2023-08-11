import java.util.*;

/**
* 최대공약수
* 기약분수
* 소인수분해
**/
class Solution {
    public int solution(int a, int b) {
        // 최대공약수로 나눠 기약분수
        int gcd = getGcd(a, b);
        int a1 = a / gcd;
        int b1 = b / gcd;

        // 분모의 소인수분해
        List<Integer> primeNumbers = primefactor(b1);
        return primeNumbers.stream().filter(i -> (i != 2) && (i != 5)).count() > 0 ? 2 : 1;
    }
    
    public int getGcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGcd(num2, num1 % num2);
    }
    
    public List<Integer> primefactor(int num) {
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