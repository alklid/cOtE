package alklid.algorithm.study.recursive;

/**
 * 재귀 정의하기
 * 1. 상태 정의
 *      - 부분 문제를 해결해 나가는데 필요한 변수들
 * 2. 종료 조건
 *      - 재귀를 통한 부분 문제가 점점 작아져 결국 이어지는 부분 문제 없이 종료되어야 하는 조건
 *      - 즉시 답이 나오는 상태를 검사하여 답을 반환할 수 있도록 하는 것
 * 3. 점화식
 *      - 상태와 종료 조건을 정의 한 후, 가장 큰 상태가 어떤 과정을 거쳐 가장 작은 상태인 종료 조건으로 도달해야 하는지 정의
 *      - 상태를 전이시키는 규칙
 */
public class Power {
    public static void main(String[] args) {
        // n의 m승 구하기
        int result = power(2, 3);
        System.out.println(result);
    }

    private static int power(int n, int m) {
        if (m == 0) return 1;
        if (n == 1) return 1;
        if (n == 0) return 1;

        return n * power(n, m - 1);
    }
}
