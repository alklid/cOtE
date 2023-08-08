import java.math.BigDecimal;

class Solution {
    public String solution(String a, String b) {
        BigDecimal bigNumA = new BigDecimal(a);
        BigDecimal bigNumB = new BigDecimal(b);

        String answer = bigNumA.add(bigNumB).toString();
        return answer;
    }
}