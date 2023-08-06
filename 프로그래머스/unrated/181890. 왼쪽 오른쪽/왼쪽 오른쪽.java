import java.util.Arrays;
import java.lang.StringBuffer;

class Solution {
    public String[] solution(String[] str_list) {
        StringBuffer prefix = new StringBuffer();
        boolean existL = false;
        for (int i=0; i<str_list.length; i++) {
            if (str_list[i].equals("r")) {
                return Arrays.copyOfRange(str_list, i+1, str_list.length);
            }
            
            if (!str_list[i].equals("l")) {
                prefix.append(str_list[i]);    
            }
            else {
                existL = true;
                break;
            }
        }
        
        return (existL == false || prefix.toString().isEmpty()) ? new String[0] : prefix.toString().split("");
    }
}