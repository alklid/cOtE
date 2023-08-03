import java.util.stream.Stream;

class Solution {
    public String[] solution(String my_string) {
        validation(my_string);
        
        /*
        String[] answer = Stream.of(my_string.split(" "))
                            .filter(x -> x.trim().length() > 0)
                            .toArray(String[]::new);
        */
        
        String[] answer = my_string.trim().split("\\s+");
        return answer;
    }
    
    static void validation(String my_string) {
        // TODO validation
    }
}