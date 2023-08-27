package alklid.algorithm.practice.engineerkorea.arraystring;

/**
 * 세가지 문자열 편집기능이 있다.
 * - 문자를 한개 삽입하는 기능 (insert) : ple -> pale
 * - 문자를 한개 삭제하는 기능 (remove) : pale -> pal
 * - 문자를 한개 교체하는 기능 (replace) : pale -> bale
 *
 * 주어진 두개의 문자열이 편집기능을
 * 단 한번만 이용한 경우(또는 한번도 이용하지 않은 경우) 인지를 알아내는 함수를 구현.
 *
 * 편집을 N 번 하면 최대 자리수가 N 만큼 발생함.
 * 따라서 0번 또는 한번만 편집을 하면 자리수는 0, 1의 차이가 발생함. 이보다 크면 1번 이상 편집한 것임.
 *
 * insert, remove 의 경우 자리수가 차이가 있으니
 * 짧은 자리수와 긴 자리수로 구분해서 짧은 자리수의 글자가 긴 자리수의 글자에 모두 포함되는지 확인
 *
 * replace 의 경우 자리수가 같아야 하고
 * 동일한 글자를 제거해서, 남아 있는게 없거나  서로 다른 한글자만 남아 있어야 함.
 */
public class OnceEditor {
    public static void main(String[] args) {
        System.out.println(solution1("ple", "pale")); // t
        System.out.println(solution1("pale", "pal")); // t
        System.out.println(solution1("pale", "bale")); // t
        System.out.println(solution1("pale", "pas")); // f
        System.out.println(solution1("pale", "paxe")); // t
        System.out.println(solution1("joy", "joy")); // t
        System.out.println(solution1("joy", "x1y")); // f
        System.out.println(solution1("joy", "yjo")); // f

        System.out.println("-----");

        System.out.println(solution2("ple", "pale")); // t
        System.out.println(solution2("pale", "pal")); // t
        System.out.println(solution2("pale", "bale")); // t
        System.out.println(solution2("pale", "pas")); // f
        System.out.println(solution2("pale", "paxe")); // t
        System.out.println(solution2("joy", "joy")); // t
        System.out.println(solution2("joy", "x1y")); // f
        System.out.println(solution2("joy", "yjo")); // f
    }


    /**
     * 한번에 같이 검사
     */
    private static boolean solution2(String s, String e) {
        String ss = s;
        String ls = e;
        if (s.length() > e.length()) {
            ss = e;
            ls = s;
        }

        if (ls.length() - ss.length() > 1) return false;

        boolean isNext = false;
        for (int i=0, j=0; i<ss.length(); i++, j++) {
            if (ss.charAt(i) != ls.charAt(j)) {
                if (isNext) {
                    return false;
                }
                if (ss.length() != ls.length()) {
                    if (ss.charAt(i) != ls.charAt(++j)) {
                        return false;
                    }
                }
                isNext = true;
            }
        }

        return true;
    }


    /**
     * 문자의 길이 비교를 통해 insert/remove, replace 를 별도로 검사
     */
    private static boolean solution1(String s, String e) {
        int diffLength = Math.abs(s.length() - e.length());
        if (diffLength == 1) {
            return checkInsertOrRemove(s, e);
        }
        else if (diffLength == 0) {
            return checkReplace(s, e);
        }
        else {
            return false;
        }
    }

    private static boolean checkInsertOrRemove(String s, String e) {
        String shortStr = s;
        String longStr = e;
        if (s.length() > e.length()) {
            shortStr = e;
            longStr = s;
        }

        for (int i=0; i<shortStr.length(); i++) {
            char sc = shortStr.charAt(i);
            if (sc != longStr.charAt(i) && sc != longStr.charAt(i+1)) {
                return false;
            }
        }

        return true;
    }


    private static boolean checkReplace(String s, String e) {
        boolean isReplace = false;

        for (int i=0; i<s.length(); i++) {
            char sc = s.charAt(i);
            char ec = e.charAt(i);
            if (sc != ec) {
                if (isReplace) {
                    return false;
                }
                else {
                    isReplace = true;
                }
            }
        }

        return true;
    }
}
