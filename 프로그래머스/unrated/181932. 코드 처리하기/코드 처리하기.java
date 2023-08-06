class Solution {
    public String solution(String code) {
        StringBuffer ret = new StringBuffer();
        
        int mode = 0;
        char[] codes = code.toCharArray();
        for (int i=0; i<codes.length; i++) {
            if (codes[i] == '1') {
                mode = (mode == 0) ? 1 : 0;
            }
            
            else {
                if (i % 2 == mode) {
                    ret.append(codes[i]);
                }
            }
        }
        
        String answer = (ret.length() == 0) ? "EMPTY" : ret.toString();
        return answer;
    }
}