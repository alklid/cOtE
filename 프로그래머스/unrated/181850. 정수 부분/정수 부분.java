class Solution {
    public int solution(double flo) {
        validation(flo);
        
        int answer = (int)flo;
        return answer;
    }
    
    static void validation(double input) {
        if (input < 0 || input > 100) {
            // bad input, throw exception
        }
    } 
}