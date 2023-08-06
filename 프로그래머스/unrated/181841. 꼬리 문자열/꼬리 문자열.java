import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] str_list, String ex) {
        /*
        StringBuffer addStr = new StringBuffer();
        for (String str : str_list) {
            if (!str.contains(ex)) {
                addStr.append(str);
            }
        }
        String answer = addStr.toString();
        return answer;
        */
        
        String answer = Arrays.stream(str_list)
                            .filter(str -> !str.contains(ex))
                            .collect(Collectors.joining());
        return answer;
    }
}