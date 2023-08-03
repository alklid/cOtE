class Solution {
    public String solution(String my_string, int[] index_list) {
        validation(my_string, index_list);

        String answer = "";
        
        char[] ch = my_string.toCharArray();
        for (int i : index_list) {
            answer += ch[i];
        }
        
        return answer;
    }
    
    static void validation(String my_string, int[] index_list) {
        int len = my_string.length();
        if (len < 1 || len > 1000) {
            // bad input, throw exception
        }
        
        if (!my_string.matches("^[a-z]$")) {
            // bad input, throw exception
        }
        
        int indexListLen = index_list.length;
        if (indexListLen < 1 || indexListLen > 1000) {
            // bad input, throw exception
        }
        
        for (int i : index_list) {
            if (i < 0 || i >= len) {
                // bad input, throw exception
                break;
            }
        }
    }
}