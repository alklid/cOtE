package alklid.algorithm.study.primenumber;

import java.util.Arrays;

/**
 * 소수 (Prime Number)
 *
 * 소수 : 소중한 수. 나 외에는 곱해서 나오지 않음.
 * 합성수 : 나 말고도 다른 수들로 합성해서 만들 수 있음.
 * 약수 : a=bg 일때, a 는 b 의 배수, b 는 a 의 약수라고 함.
 *
 * 주의)
 * 1은 소수도 아니고 합성수도 아니다!
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int num = 100; // 주어진 수 이하의 소수를 찾아라.

        for (int i = 1; i <= num; i++) {
            boolean isPrime = isPrime(i);
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // 에라토스테네스의 체
        boolean[] isPrime = new boolean[num + 1]; // index 를 정수로 사용하기 쉽도록 배열의 크기를 하나 더 늘려준다.
        eratosthenes(num, isPrime);
        for (int i = 1; i <= num; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }


    /**
     * O(√N) 의 시간 복잡도. 입력의 개수가 적다면 그럭저럭 사용 가능
     */
    private static boolean isPrime(int num) {
        // 1, 2는 예외처리
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


    /**
     * 에라토스테네스의 체 (Sieve of Eratosthenes)
     * 2부터 수를 모두 나열한 이후에, 순회하면서 주어진 수의 배수를 지우기를 반복해서 남은 것들이 소수.
     * 2 3 4 5 6 7 8 9 10
     * 2 3 x 5 x 7 x 9 x  -> 2의 배수를 지움
     * 2 3 x 5 x 7 x x x  -> 3의 배수를 지움
     * 2 3 x 5 x 7 x x x  -> 5의 배수를 지움
     * 2 3 x 5 x 7 x x x  -> 7의 배수를 지움
     *
     * 시간 복잡도가 까다로운데 O(nloglogn) 으로 증명될 수 있고, 이는 거의 O(n) 과 비슷하다고 볼 수 있음.
     * 시간 복잡도보다 메모리의 사용량을 고려해야 함.
     */
    private static void eratosthenes(int num, boolean[] isPrime) {
        // 모두 true 초기화
        Arrays.fill(isPrime, true);

        // 1은 항상 예외 처리
        isPrime[0] = false;
        isPrime[1] = false;

        int sqrtNumber = ((Double) Math.sqrt(num)).intValue();
        for (int i = 2; i <= sqrtNumber; i++) {
            // 아직 지워지지 않은 수의 경우
            if (isPrime[i]) {
                // i 의 배수 j 들에 대해서 지움
                // 단, i*i 의 미만의 배수는 이미 지워 졌으므로 신경쓰지 않는다.
                for (int j = i*i; j <= num; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }


}
