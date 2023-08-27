package alklid.algorithm.practice.engineerkorea.arraystring;

public class PrintSortedString {
    public static final int C = 26; // a-z 갯수

    public static void main(String[] args) {
        printSortedStrings(2);
    }

    private static void printSortedStrings(int k) {
        printSortedStrings(k, "");
    }

    private static void printSortedStrings(int k, String prefix) {
        // 원하는 문자열 갯수의 조합이 완성되었을 때
        if (k == 0) {
            if (isInOrder(prefix)) {
                System.out.println(prefix);
            }
        }
        else {
            for (int i = 0; i < C; i++) {
                char c = ithLetter(i);
                printSortedStrings(k - 1, prefix + c);
            }
        }
    }

    private static boolean isInOrder(String s) {
        for (int i=1; i<s.length(); i++) {
            int prev = ithLetter(s.charAt(i-1));
            int curr = ithLetter(s.charAt(i));
            if (prev > curr) {
                return false;
            }
        }
        return true;
    }

    private static char ithLetter(int i) {
        return (char) (((int)'a') + i);
    }
}
