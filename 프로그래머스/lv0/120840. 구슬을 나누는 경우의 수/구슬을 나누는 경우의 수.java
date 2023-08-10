import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        BigInteger[] fact = new BigInteger[balls+1];
        factorial(fact);
        
        if (balls == share) {
            return 1;
        }
        
        return fact[balls].divide(fact[balls - share].multiply(fact[share])).intValue();
    }
    
    static void factorial(BigInteger[] fact) {
        fact[0] = BigInteger.valueOf(1);
        fact[1] = BigInteger.valueOf(1);
        
        for (int i=1; i<fact.length; i++) {
            fact[i] = fact[i-1].multiply(BigInteger.valueOf(i));
        }
    }
}