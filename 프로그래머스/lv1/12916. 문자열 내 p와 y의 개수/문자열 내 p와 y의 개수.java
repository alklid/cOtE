import java.util.Locale;

class Solution {
    boolean solution(String s) {
        s = s.toLowerCase(Locale.ROOT);
        int pLen = s.length() - s.replace("p", "").length();
        int yLen = s.length() - s.replace("y", "").length();

        return pLen == yLen;
    }
}