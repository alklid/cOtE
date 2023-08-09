class Solution {
    public String solution(String rsp) {
        StringBuffer sb = new StringBuffer();

        for (String s : rsp.split("")) {
            sb.append(win(s));
        }
        String answer = sb.toString();
        return answer;
    }
    
    static String win(String rsp) {
        switch (rsp) {
            case "2" :
                return "0";
            case "0" :
                return "5";
            case "5" :
                return "2";
            default :
                return "";
        }
    }
}