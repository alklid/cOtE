class Solution {
    public String solution(String polynomial) {
        int num = 0;
        int xCnt = 0;
        for (String s : polynomial.split(" ")) {
            if ("+".equals(s)) {
                continue;
            }
            
            if (s.indexOf("x") == -1) {
                num += Integer.parseInt(s);
            }
            else {
                if (s.length() == 1) {
                    xCnt++;
                }
                else {
                    xCnt += Integer.parseInt(s.substring(0, s.length()-1));
                }
            }
        }
        
        return String.format("%s%s%s%s", 
                             (xCnt > 1) ? xCnt : "",
                             (xCnt != 0) ? "x" : "",
                             (xCnt != 0 && num > 0) ? " + " : "",
                             (num > 0) ? num : "");
    }
}