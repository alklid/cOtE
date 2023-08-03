class Solution {
    public String solution(String my_string, int s, int e) {
        String prefix = my_string.substring(0, s);
        String search = my_string.substring(s, e+1);
        String reverse = new StringBuffer(search).reverse().toString();
        String suffix = my_string.substring(e+1);
        
        String answer = prefix.concat(reverse).concat(suffix);
        return answer;
    }
}