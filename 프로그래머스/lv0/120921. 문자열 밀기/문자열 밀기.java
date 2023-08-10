/**
* 문자열을 오른쪽으로 한 칸씩 이동시키면서 특정 문자열과 같은지 확인
* 확인만 하려면 repeat() 이용할 수 있으나 횟수를 구하려면 이동하면서 확인이 필요
**/
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