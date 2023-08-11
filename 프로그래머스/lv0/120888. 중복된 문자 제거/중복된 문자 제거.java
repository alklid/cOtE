import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<String> str = new LinkedHashSet<>();
        for (String s : my_string.split("")) {
            str.add(s);
        }
        
        return String.join("", str);
    }
}