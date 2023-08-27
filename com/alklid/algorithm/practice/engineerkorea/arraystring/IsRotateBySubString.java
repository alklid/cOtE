package alklid.algorithm.practice.engineerkorea.arraystring;

/**
 * isSubString() 함수는 어떤 문자열안에 다른 문자열이 포함되어 있는지 확인하는 함수.
 * 두개의 문자열이 주어졌을 때, isSubString() 함수를 한번만 사용해서
 * 두개의 문자열이 회전된 문자열인지 확인하는 함수를 작성.
 *
 * 회전된 문자열 : string -> trings -> ringst -> ... -> string
 */
public class IsRotateBySubString {
    public static void main(String[] args) {
        System.out.println(solution("string", "trings"));
        System.out.println(solution("string", "ringst"));
        System.out.println(solution("string", "ingrst"));
        System.out.println(solution("string", "ingstr"));

    }

    private static boolean solution(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        StringBuilder sb = new StringBuilder();
        sb.append(s2);
        sb.append(s2);

        return isSubString(s1, sb.toString());
    }

    private static boolean isSubString(String s1, String s2) {
        return s2.contains(s1);
    }
}
