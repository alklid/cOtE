import java.util.stream.Stream;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = Stream.of(myStr.split("[abc]"))
                            .filter(str -> str.length() > 0)
                            .toArray(String[]::new);
        if (answer.length == 0) {
            answer = new String[] {"EMPTY"};
        }
        return answer;
    }
}