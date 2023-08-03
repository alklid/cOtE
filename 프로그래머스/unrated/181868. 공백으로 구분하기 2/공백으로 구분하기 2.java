import java.util.stream.Stream;

class Solution {
    public String[] solution(String my_string) {
        validation(my_string);
        
        String[] answer = Stream.of(my_string.split(" "))
                            .map(String::trim)
                            .filter(x -> x.length() > 0)
                            .toArray(String[]::new);
        return answer;
    }
    
    static void validation(String my_string) {
        // TODO validation
    }
}