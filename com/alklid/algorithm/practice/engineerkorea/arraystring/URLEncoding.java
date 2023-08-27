package alklid.algorithm.practice.engineerkorea.arraystring;

/**
 * 주어진 문자열의 공백을 %20 으로 변환하는 함수를 구현하시오.
 * 문자열의 맨끝에는 변환에 필요한 충분한 공백이 있고,
 * 실제 문자열의 사이즈를 알고 있음.
 *
 * Example:
 * input : "Mr John Smith    ", 13
 * outpu : "Mr%20John%20Smith"
 */
public class URLEncoding {
    public static void main(String[] args) {
        // StringBuilder 사용
        System.out.println(solution1("Mr John Smith    ", 13));

        // input 문자열 이용 -> 변환에 필요한 충분한 공백이 있다는 문제 의도
        System.out.println(solution2("Mr John Smith    ", 13));
        System.out.println(solution3("Mr John Smith    ", 13));
    }

    /**
     * solution2 와 같은 풀이
     * 배열의 총 길이를 s 의 길이로 구하지 않고, 공백을 치환했을때의 문자 갯수를 더해서 구함
     */
    private static String solution3(String s, int len) {
        char[] c = s.toCharArray();

        int spaces = 0;
        for (int i=0; i<len; i++) {
            if (c[i] == ' ') spaces++;
        }

        int i = len + (spaces*2) - 1 ;
        for (int p=len-1; p>=0; p--) {
            if (c[p] == ' ') {
                c[i--] = '0';
                c[i--] = '2';
                c[i--] = '%';
            }
            else {
                c[i--] = c[p];
            }
        }

        return new String(c);
    }


    /**
     * 주어진 문자열에 이미 변환에 필요한 충분한 공백이 있음
     * 뒤에서 부터 복사해줌
     * 뒤에서 부터 index 시작, 문자열의 크기 부터 복사할 pointer 시작
     */
    private static String solution2(String s, int len) {
        char[] c = s.toCharArray();
        int i = s.length()-1;

        for (int p=len-1; p>=0; p--) {
            if (c[p] == ' ') {
                c[i] = '0';
                i--;
                c[i] = '2';
                i--;
                c[i] = '%';
                i--;
                continue;
            }

            c[i] = s.charAt(p);
            i--;
        }

        return new String(c);
    }

    /**
     * StringBuilder 사용
     */
    private static String solution1(String s, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            }
            else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
