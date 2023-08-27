package alklid.algorithm.study.string;

import java.util.Arrays;

/**
 * 주어진 두개의 문자열이 서로 치환되는지을 알아내는 함수
 *  - 문자열로 가능한 순열 조합중에 같은 문자열이 존재한다는 것.
 *  - 가지고 있는 문자의 종류와 갯수가 같아야 한다는 것.
 *  - 대소문자를 구별할 것인지와, 공백처리(무시?포함?)를 확실히 정의해 놓아야 함
 */
public class StringPermutation {
    public static void main(String[] args) {
        // array sort
        System.out.println(solution1("ABC", "BCA"));
        System.out.println(solution1("ABC", "BDA"));

        // array ascii
        System.out.println(solution2("ABC", "BCA"));
        System.out.println(solution2("ABC", "BDA"));
    }


    /**
     * 문자를 정렬한 이후에 앞에서 부터 비교
     */
    private static boolean solution1(String s, String t) {
        if (s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
    }

    private static Object sort(String text) {
        char[] content = text.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }


    /**
     * 문자열이 ASCII 로 구성되어 있다면,
     * 첫번째 문자열은 배열의 각 ascii 값의 index 에 있는 값을 1씩 더하고
     * 두번째 문자열은 배열의 각 ascii 값의 index 에 있는 값을 1씩 빼면
     * 최종 배열이 모두 0이면 치환 가능
     *
     * 첫번째 문자열로 int[] 배열에 마킹해놓고,
     * 두번째 문자열로 int[] 배열에서 마킹을 제거하면
     * 만약 문자열이 모두 같다면 int[] 배열의 모든 값은 0 일 것임.
     */
    private static boolean solution2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] permutation = new int[128];
        for (char c: s.toCharArray()) {
            permutation[c]++;
        }

        for (char c: t.toCharArray()) {
            permutation[c]--;
            if (permutation[c] < 0) return false;
        }

        return true;
    }

}
