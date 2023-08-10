import java.math.BigInteger;

/**
* nCr = n-1Cr-1 + n-1Cr
*  n개중 r개를 뽑는 경우의 수는, 어떤 특정한 한 개를 포함하여 뽑는 경우와 특정한 한 개를 포함하지 않고 뽑는 경우의 수의 합과 같음.
*  예) 5C3 = 4C2 + 4C3 
*         = (3C1 + 3C2) + (3C2 + 3C3) 
*         = ((2C0 + 2C1) + (2C1 + 2C2)) + ((2C1 + 2C2) + (2C2 + 2C3)) 
*         = .... 계속 작은 수로 분리할 수 있음
*
*/
class Solution {
    public int solution(int balls, int share) {
        // nCr = n-1Cr-1 + n-1Cr 이용 방식
        return division(balls,share);
        
        /*
        // BigInterger 이용 방식
        BigInteger[] fact = new BigInteger[balls+1];
        factorial(fact);
        
        if (balls == share) {
            return 1;
        }
        
        return fact[balls].divide(fact[balls - share].multiply(fact[share])).intValue();
        */
    }

    public int division(int balls, int share) {
        if (balls == share || share == 0) {
            return 1;
        }
        
        return division(balls-1,share-1) + division(balls-1,share);
    }        

    public void factorial(BigInteger[] fact) {
        fact[0] = BigInteger.valueOf(1);
        fact[1] = BigInteger.valueOf(1);
        
        for (int i=1; i<fact.length; i++) {
            fact[i] = fact[i-1].multiply(BigInteger.valueOf(i));
        }
    }
}