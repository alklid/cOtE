class Solution {
    public int solution(double flo) {
        validation(flo);
        
        int answer = new Double(flo).intValue();
        return answer;
    }
    
    static void validation(double input) {
        if (input < 0 || input > 100) {
            // bad input, throw exception
        }
    } 
}