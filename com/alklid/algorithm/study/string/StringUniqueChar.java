package alklid.algorithm.study.string;


import java.util.HashMap;

/**
 * 문자열 안의 문자들이 고유한지 확인
 */
public class StringUniqueChar {
    public static void main(String[] args) {
        // array
        System.out.println(solution1("abcddfg"));
        System.out.println(solution1("abcdefg"));

        // hashmap
        System.out.println(solution2("abcddfg"));
        System.out.println(solution2("abcdefg"));

        // bit
        System.out.println(solution3("abcddfg"));
        System.out.println(solution3("abcdefg"));

        // no data structure
        System.out.println(solution4("abcddfg"));
        System.out.println(solution4("abcdefg"));
    }


    /**
     * 문자열이 ASCII 로만 구성된 문자열이라면 모든 문자가 128로 표현이 됨으로,
     * 128개의 boolean 배열에 1/0 처리를 통해 중복 확인
     */
    private static boolean solution1(String text) {
        // 문자갯수가 128개 이상이면 최소 한개 이상의 중복된 문자가 이미 존재
        if (text.length() > 128) return false;

        boolean[] unique = new boolean[128];
        for (char c : text.toCharArray()) {
            int val = c;
            if (unique[val]) {
                return false;
            }
            unique[val] = true;
        }
        return true;
    }


    /**
     * Unicode 로 구성된 문자열이라면 표현 갯수가 너무 많아 HashMap 을 사용
     */
    private static boolean solution2(String text) {
        HashMap<Integer, Boolean> unique = new HashMap<>();
        for (char c : text.toCharArray()) {
            int val = c;
            if (unique.containsKey(val)) {
                return false;
            }
            unique.put(val, true);
        }
        return true;
    }


    /**
     * 문자가 소문자로만 구성되어 있다면 bit 연산자로 사용
     * a-z 까지는 26개, int bit 크기는 2³¹ 임으로 초과하지 않음
     * a(97), z(122) 여기서 모두 a 만큼 빼면 a(0), z(25) 가 되고
     * 자리수만큼 shift(<<) 해주면 해당 자리의 bit 가 1/0 에 따라 중복여부 체크
     *
     * i 번째 자리의 bit 가 1 인지 0 인지 확인하는 함수
     * i 번째 자리만 1인 숫자를 만들고 AND(&) 처리
     * AND(&) 의 특성 : 0과 & 하면 0, 1과 & 하면 원본값
     *
     * i 번째 자리의 bit 를 1로 설정하는 함수
     * i 번째 자리만 1인 숫자를 만들고 OR(|) 처리
     * OR(|) 의 특성 : 0과 | 하면 원본값, 1과 | 하면 1
     */
    private static boolean solution3(String text) {
        int unique = 0;
        for (char c: text.toCharArray()) {
            int i = c - 'a';
            if ((unique & (1 << i)) != 0) {
                return false;
            }
            unique = unique | (1 << i); // unique |= (1 << i);
        }
        return true;
    }


    /**
     * 추가 저장공간을 사용하지 못하는 경우의 처리 고민,
     * 1. 첫글자를 기준으로 나머지 글자를 순환하면서 비교, 이를 한글자씩 이동하면서 반복
     *    - O(n²)
     * 2. 입력데이터를 변형해도 된다면 정렬을 한 이후에, 바로 옆에 있는 것들과만 비교
     *    - O(n log n)
     */
    private static boolean solution4(String text) {
        // 복잡도가 높아서 사용하지 않음.
        return false;
    }

}
