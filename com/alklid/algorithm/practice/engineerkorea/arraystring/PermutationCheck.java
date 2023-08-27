package alklid.algorithm.practice.engineerkorea.arraystring;

/**
 * 주어진 문자열이 회문(palindrome) 을 만들 수 있는 문자열의
 * 치환(permutation) 인지를 확인하는 함수를 만드시오.
 *
 * 회문(palindrome) : 앞뒤로 읽어도 동일한 것. 예) mom, dad
 *  - 짝수의 경우, 중앙 인덱스를 기준으로 거울처럼 대칭
 *  - 홀수의 경우, 중앙 문자열을 제외하고 짝수개면 거울처럼 대칭
 *
 * 치환(permutation) : 문자열 안에서 문자의 순서를 바꾼 것. 예) mom, mmo, omm
 *
 * 여기서는 치환된 문자도 회문이 가능한지를 확인하는 것이니
 * 거울처럼 대칭됨까지 비교할 필요는 없고,
 * 문자의 갯수가 짝수면, 문자들이 짝수개씩 있어야 함.
 * 문자의 갯수가 홀수면, 1개의 문자를 제외하고 나머지 문자들은 짝수개씩 있어야 함.
 * 이 정도만 체크해도 조건을 만족함.
 */
public class PermutationCheck {
    public static void main(String[] args) {
        // array
        System.out.println(solution1("aa bb cc dd"));
        System.out.println(solution1("aa bb cc dd e"));
        System.out.println(solution1("aa bb cc dd e fff"));

        // array 코드라도 줄여보자
        System.out.println(solution2("aa bb cc dd"));
        System.out.println(solution2("aa bb cc dd e"));
        System.out.println(solution2("aa bb cc dd e fff"));

        // bit
        System.out.println(solution3("aa bb cc dd"));
        System.out.println(solution3("aa bb cc dd e"));
        System.out.println(solution3("aa bb cc dd e fff"));
    }

    /**
     * 짝수 갯수면 0, 홀수 갯수면 1을 bit 자리수에 저장해
     * 나중에 1이 없거나 딱 한개만 있는지를 확인.
     * @param s
     * @return
     */
    private static boolean solution3(String s) {
        int bitVector = createBitVector(s);

        // bitVector == 0 -> 모두 짝수개이거나
        // checkExactlyOneBitSet -> 홀수가 1개 또는 없는지 확인
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    private static int createBitVector(String s) {
        int bitVector = 0;
        for (char c: s.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;
        int mask = 1 << index;

        // AND(&) 연산하여 0을 반환했다는 것은 겹치는 곳이 없다는 것(원본값이 0이라는 것)
        //  - AND(&) 의 특성 : 0과 & 하면 0, 1과 & 하면 원본값
        // 따라서 기존에 짝수개가 있었다는 것이니까,
        // 이제 홀수개가 되었음을 설정하기 위해 1로 설정
        // 1로 설정하기 위해서는 OR(|) 연산처리
        //  - OR(|) 의 특성 : 0과 | 하면 원본값, 1과 | 하면 1
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        }
        // 기존에 홀수개가 있었다는 것이니까
        // 이제 짝수개가 되었음을 설정하기 위해 0으로 설정
        // 0 으로 설정하기 위해서는 NOT(~) 연산된걸 AND(&) 연산처리
        else {
            bitVector &= ~mask;
        }

        return bitVector;
    }

    /**
     * bitVector 에서 홀수개가 한개 또는 없는지 확인하는 방법
     * bitVector & (bitVector -1) != 0 이면 홀수가 한개 이상 있음.
     */
    private static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector -1)) == 0;
    }


    /**
     * solution1 의 코드라도 줄여보자.
     */
    private static boolean solution2(String s) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c: s.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;

                if (table[x] % 2 == 1) {
                    countOdd++;
                }
                else {
                    countOdd--;
                }
            }
        }

        return countOdd <= 1;
    }

    /**
     * 시간 복잡도 O(n), 더 이상 최적화 어려움
     */
    private static boolean solution1(String s) {
        int[] table = buildCharFrequencyTable(s);
        return checkMaxOneOdd(table);
    }

    private static int[] buildCharFrequencyTable(String s) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c: s.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }

        return table;
    }

    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count: table) {
            if (count % 2 == 1) {
                if (!foundOdd) {
                    foundOdd = true;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
