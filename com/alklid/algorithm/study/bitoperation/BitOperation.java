package alklid.algorithm.study.bitoperation;


/**
 * Integer - 4 bytes - 32 bits
 * 맨 앞에는 음수/양수 처리,
 * -2³¹ ~ 2³¹-1 (2³²에서 맨 앞에는 음수/양수 처리에 사용되니 1개를 뺀것만 사용가능)
 *
 *
 * OR (|)
 *  - 두개 중에 하나라도 1이면 1 -> 둘다 0인것들만 0
 *  - 0과 OR 하면 자기 자신이 나옴
 *  - 1과 OR 하면 모두 1이 나옴
 *  - 자신과 OR 하면 자기 자신이 나옴
 *
 * AND (&)
 *  - 둘다 1인것들만 1
 *  - 0과 AND 를 하면 모두 0이 나옴
 *  - 1과 AND 를 하면 원본 값이 나옴
 *  - 자신과 AND 하면 자기 자신이 나옴
 *
 * NOT (~) : 0과 1을 반대로 처리
 *
 * XOR (^)
 *  - 두개가 다른 값을 가지면 1 -> 둘다 같으면 0
 *  - 0과 XOR 를 하면 자기 자신이 나옴
 *  - 1과 XOR 를 하면 자기 자신의 NOT 값이 계산됨
 *  - 자신 자신을 XOR 하면 모두 0이 나옴
 *
 * Left Shift
 *  - 왼쪽으로 밀고 0으로 채움. 예) 1001 << 2 -> 100100
 *
 * Right shift (>>)
 *  - arithmetic right shift
 *     - 부호 처리를 위한 첫 bit 는 유지하고 오른쪽으로 밀고 채움 없음
 *     - 계속 밀면 모두 1이 됨.
 *  - logical right shift (>>>)
 *     - 부호 처리를 위한 첫 bit 를 무시하고 오른쪽으로 밀고 앞은 0으로 채움
 *     - 계속 밀면 모두 0이 됨.
 */
public class BitOperation {

    /**
     * i 번째 자리의 bit 가 1 인지 0 인지 확인하는 함수
     * i 번째 자리만 1인 숫자를 만들고 AND(&) 처리
     * AND(&) 의 특성 : 0과 & 하면 0, 1과 & 하면 원본값
     */
    static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    /**
     * i 번째 자리의 bit 를 1로 설정하는 함수
     * i 번째 자리만 1인 숫자를 만들고 OR(|) 처리
     * OR(|) 의 특성 : 0과 | 하면 원본값, 1과 | 하면 1
     */
    static int setBit(int num, int i) {
        return num | (1 << i);
    }

    /**
     * i 번째 자리의 bit 를 0으로 설정하는 함수
     * i 번째 자리만 0이고 나머지는 1인 숫자 만들고 AND(&) 처리
     *  - i 번째 자리만 1인 숫자를 만들고 NOT(~) 해서 반대로 만듬
     * AND(&) 의 특성 : 0과 & 하면 0, 1과 & 하면 원본값
     */
    static int clearBit(int num, int i) {
        return num & ~(1 << i);
    }

    /**
     * i 번째 포함 왼쪽을 모두 0으로 설정하는 함수
     * 왼쪽부터 i 번째 자리까지는 0이고, 나머지는 1인 숫자 만들고 AND(&) 처리
     *  - i 번째 자리만 1인 숫자를 만들고 -1 (2진수 연산)
     * AND(&) 의 특성 : 0과 & 하면 0, 1과 & 하면 원본값
     */
    static int clearLeftBit(int num, int i) {
        return num & ((1 << i) -1);
    }

    /**
     * i 번째 포함 오른쪽을 모두 0으로 설정하는 함수
     * 왼쪽 부터 i 번째 자리까지는 1이고, 나머지는 0인 숫자 만들고 AND(&) 처리
     *  - 모든 bit 가 1인 숫자는 -1, -1을 i번째 자리까지 <<
     * AND(&) 의 특성 : 0과 & 하면 0, 1과 & 하면 원본값
     */
    static int clearRightBit(int num, int i) {
        return num & -1 << (i+1);
    }

    /**
     * i 번째 자리를 val 로 업데이트 하는 함수
     * 해당 자리수의 비트를 0으로 만든 다음, val 로 변경
     * 해당 자리수의 비트를 0으로 만듬
     *   - 모두 1이고 해당 자리수만 0인 숫자와 AND(&) 처리
     *   - 모두 1이고 해당 자리수만 0인 숫자는, 해당 자리수만 1인 숫자를 NOT(~) 처리
     * 해당 자리수의 비트를 val 로 변경
     *   - 모두 0이고 해당 자리수만 val 인 숫자와 OR(|) 처리
     *   - 모두 0이고 해당 자리수만 val 인 숫자는, val 을 자리수 만큼 << 처리
     *
     * AND(&) 의 특성 : 0과 & 하면 0, 1과 & 하면 원본값
     * OR(|) 의 특성 : 0과 | 하면 원본값, 1과 | 하면 1
     */
    static int updateBit(int num, int i, boolean val) {
        return (num & ~(1 << i)) | ((val?1:0) << i);
    }


    public static void main(String[] args) {
        // 1 0 0 1 -> true
        System.out.println(getBit(9, 3));

        // 0 1 0 1 -> false
        System.out.println(getBit(5, 3));

        // 0 1 0 1 -> 1 1 0 1 (13)
        System.out.println(setBit(5, 3));

        // 1 0 0 1 -> 0 0 0 1 (1)
        System.out.println(clearBit(9, 3));

        // ... 1 0 1 0 1 0 0 1 -> ... 0 0 0 1 (1)
        System.out.println(clearLeftBit(169, 3));

        // ... 1 0 1 0 1 0 0 1 -> ... 1 0 1 0 0 0 0 0 (160)
        System.out.println(clearRightBit(169, 3));

        // ... 1 0 1 0 1 0 0 1 -> ... 1 0 1 0 0 0 0 1 (161)
        System.out.println(updateBit(169, 3, false));
    }
}
