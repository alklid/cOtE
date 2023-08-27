package alklid.algorithm.study.primenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 소인수 분해 (Prime Factorization)
 *
 * 소인수 : 자연수의 인수 중에서 소수인 것
 * 소인수 분해 : 어떤 자연수를 소인수들의 곱으로만 나타낸 것.(소수들만 남을때까지 분해하는것)
 * 소인수 분해에 대한 학습은 youtube 검색을 권장.
 *
 * 예) 12의 소인수 분해
 *     1) 12의 인수 : 1, 2, 3, 4, 6, 12
 *     2) 이중에 소수는 : 2, 3
 *     3) 소인수 분해 : 2² * 3
 */
public class PrimeFactorization {

    public static void main(String[] args) {
        PrimeFactorization primeFactorization = new PrimeFactorization();

        System.out.println("----- simple");
        List<Integer> primeFactorNumbers = primeFactorization.factorSimple(12);
        System.out.println(primeFactorNumbers);

        primeFactorNumbers = primeFactorization.factorSimple(25);
        System.out.println(primeFactorNumbers);

        primeFactorNumbers = primeFactorization.factorSimple(48);
        System.out.println(primeFactorNumbers);

        System.out.println("----- eratosthenes");
        primeFactorNumbers = primeFactorization.factor(12);
        System.out.println(primeFactorNumbers);

        primeFactorNumbers = primeFactorization.factor(25);
        System.out.println(primeFactorNumbers);

        primeFactorNumbers = primeFactorization.factor(48);
        System.out.println(primeFactorNumbers);
    }


    /**
     * 소수 판별 알고리즘을 응용. O(√N) 의 시간 복잡도.
     * 2부터 시작해서 n 의 소인수가 될 수 있는 수들을 순회하면서, n의 약수를 찾을 때마다 n 을 이 숫자로 나눔.
     */
    private List<Integer> factorSimple(int num) {
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


    /**
     * 에라토스테네스의 체를 이용한 소인수 분해
     * {@link alklid.algorithm.study.primenumber.PrimeNumber#eratosthenes(int, boolean[])}
     *
     * 여기서는 에라토스테네스의 체를 수행하면서 소인수분해를 위한 정보도 저장하도록 변형
     */

    // 소인수분해 대상 숫자의 크기에 맞춰 배열의 크기도 적당히 조정
    // minFactor[i] = i 의 가장 작은 소인수 (i 가 소수인 경우 자기 자신)
    private int[] minFactor;

    private void eratosthenes2(int num) {
        minFactor = new int[num+1];

        // 1은 항상 예외 처리
        minFactor[0] = -1;
        minFactor[1] = -1;

        // 모든 숫자를 처음에는 소수로 표시
        for (int i = 2; i <= num; i++) {
            minFactor[i] = i;
        }

        // 에라토스테네스의 체를 수행
        int sqrtNumber = ((Double) Math.sqrt(num)).intValue();
        for (int i = 2; i <= sqrtNumber; i++) {
            if (minFactor[i] == i) {
                for (int j = i*i; j <= num; j += i) {
                    // 아직 약수를 본 적 없는 숫자인 경우 i 를 입력해둠.
                    if (minFactor[j] == j) {
                        minFactor[j] = i;
                    }
                }
            }
        }
    }

    private List<Integer> factor(int num) {
        // 에라토스테네스 구하기
        eratosthenes2(num);

        List<Integer> primeFactorNumbers = new ArrayList<>();

        // num 가 1일 될 때까지 가장 작은 소인수로 나누기를 반복
        while (num > 1) {
            primeFactorNumbers.add(minFactor[num]);
            num /= minFactor[num];
        }

        return primeFactorNumbers;
    }

}
