import java.util.ArrayList;
import java.util.List;

class Solution {
    
    private static final char[] CHARS = "AEIOU".toCharArray();
    
    public int solution(String word) {
        return dic("").indexOf(word);
    }
    
    // 사전 만들기
    private List<String> dic(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        // 종료 조건 : 5글자가 되면 종료
        if (word.length() == 5) return words;

        for (char c : CHARS) {
            words.addAll(dic(word + c));
        }

        return words;
    }
}