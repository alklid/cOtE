import java.util.Arrays;
import java.lang.StringBuffer;

class Solution {
    public String[] solution(String[] str_list) {
        StringBuffer prefix = new StringBuffer();
        for (int i=0; i<str_list.length; i++) {
            if (str_list[i].equals("r")) {
                return Arrays.copyOfRange(str_list, i+1, str_list.length);
            }
            else if (str_list[i].equals("l")) {
                return Arrays.copyOfRange(str_list, 0, i);
            }
        }
        
        return new String[0];
    }
}