class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = my_string;
        
        for (int i=0; i<queries.length; i++) {
            int[] query = queries[i];
            
            String prefix = answer.substring(0, query[0]);
            String search = answer.substring(query[0], query[1]+1);
            String reverse = new StringBuffer(search).reverse().toString();
            String suffix = answer.substring(query[1]+1);
            
            answer = prefix.concat(reverse).concat(suffix);
        }
        
        return answer;
    }
}