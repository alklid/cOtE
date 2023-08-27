package alklid.algorithm.practice.engineerkorea.arraystring;

/**
 * 문자열을 압축하라
 * 예) aabbbccccd -> a2b3c4d
 *
 * 만약 압축본이 원본보다 크면 원본을 반환
 */
public class Compression {
    public static void main(String[] args) {
        System.out.println(solution1("aabbbccccd"));
        System.out.println(solution1("aaabbcccdxxxx"));
        System.out.println(solution1("abcd"));

        System.out.println(solution2("aabbbccccd"));
        System.out.println(solution2("aaabbcccdxxxx"));
        System.out.println(solution2("abcd"));
    }

    private static String solution2(String s) {
        String compress = compress2(s);
        return compress.length() > s.length() ? s : compress;
    }

    private static String compress2(String s) {
        int count = 0;

        // StringBuilder 내부에서 배열을 늘리는 작업을 하지 않기 위해 사이즈를 지정
        int compressSize = getTotal(s);
        if (compressSize > s.length()) {
            return s;
        }
        StringBuilder sb = new StringBuilder(compressSize);

        for (int i=0; i<s.length(); i++) {
            count++;

            // 마지막 문자이거나, 다음 문자와 다른 경우
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
                sb.append(s.charAt(i));
                sb.append(count);
                count = 0;
            }
        }

        return sb.toString();
    }

    private static int getTotal(String s) {
        int count = 0;
        int total = 0;

        for (int i=0; i<s.length(); i++) {
            count++;

            // 마지막 문자이거나, 다음 문자와 다른 경우
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
                total += 1 + String.valueOf(count).length();
                count = 0;
            }
        }

        return total;
    }


    private static String solution1(String s) {
        String compress = compress(s);
        return compress.length() > s.length() ? s : compress;
    }

    private static String compress(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        char c = s.charAt(0);
        int count = 1;
        for (int i=1; i<s.length(); i++) {
            if (c != s.charAt(i)) {
                sb.append(c);
                sb.append(count);

                c = s.charAt(i);
                count = 1;
            }
            else {
                count++;
            }
        }

        // 마지막 문자 추가
        sb.append(c);
        sb.append(count);

        return sb.toString();
    }
}
