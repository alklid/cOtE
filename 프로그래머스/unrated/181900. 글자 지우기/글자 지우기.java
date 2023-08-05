class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = my_string;
        for (int idx : indices) {
            int prefixLastIdx = idx;
            int suffixFirstIdx = idx + 1;
            
            String prefix = answer.substring(0, prefixLastIdx);
            String suffix = answer.substring(suffixFirstIdx);
            answer = prefix + "_" + suffix;
        }
        
        return answer.replace("_", "");
    }
}