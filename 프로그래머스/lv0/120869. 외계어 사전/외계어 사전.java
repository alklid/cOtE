import java.util.Arrays;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int[] dicLen = new int[dic.length];
        for (int i=0; i<dic.length; i++) {
            int match = 0;
            for (String s : spell) {
                if (dic[i].indexOf(s) != -1) {
                    match++;
                }
            }
            dicLen[i] = match;
        }
        
        return (Arrays.stream(dicLen).filter(c -> c == spell.length).count() > 0) ? 1 : 2;
    }
}