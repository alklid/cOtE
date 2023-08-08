import java.lang.Math;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[]{-1, -1};
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;
        answer = abbreviation(numer, denom);
        return answer;
    }
    
    static int[] abbreviation(int numer, int denom) {
        int gcdNum = gcd(numer, denom);
        return new int[]{numer / gcdNum, denom / gcdNum};
    }
    
    static int gcd(int numer, int denom) {
        while (denom != 0) {
            int temp = numer % denom;
            numer = denom;
            denom = temp;
        }
        
        return Math.abs(numer);
    }
    
}