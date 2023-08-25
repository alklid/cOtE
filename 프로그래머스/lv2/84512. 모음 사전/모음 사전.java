import java.util.ArrayList;
import java.util.List;

class Solution {
    
    private static final char[] CHARS = "AEIOU".toCharArray();
    
    public int solution(String word) {
        List<String> words = new ArrayList<>();
        dic("", words);
        return words.indexOf(word);
    }
    
    // 사전 만들기
    private void dic(String word, List<String> words) {
        words.add(word);

        // 종료 조건 : 5글자가 되면 종료
        if (word.length() == 5) return;

        for (char c : CHARS) {
            dic(word + c, words);
        }
    }
}