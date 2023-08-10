class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        for (int i=0; i<A.length(); i++) {
            if (A.equals(B)) {
                break;
            }
            
            A = (A.substring(A.length()-1) + A).substring(0, A.length());
            answer++;
        }
        
        return (answer == A.length()) ? -1 : answer;
    }
}