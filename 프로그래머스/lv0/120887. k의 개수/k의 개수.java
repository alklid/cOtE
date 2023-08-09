class Solution {
    public int solution(int i, int j, int k) {
        /*
        int answer = 0;
        String search = String.valueOf(k);
        for (int x=i; x<=j; x++) {
            String s = String.valueOf(x);
            answer += s.length() - s.replace(search, "").length();
        }
        return answer;
        */
        
        StringBuffer sb = new StringBuffer();
        for (int x=i; x<=j; x++) {
            sb.append(String.valueOf(x));
        }
        
        return sb.toString().length() - sb.toString().replace(String.valueOf(k), "").length();
    }
}