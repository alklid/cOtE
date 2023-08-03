class Solution {
    public int solution(String myString, String pat) {
        validation(myString, pat);
        
        int answer = (myString.toLowerCase().indexOf(pat.toLowerCase()) >= 0) ? 1 : 0;
        return answer;
    }
    
    static void validation(String myString, String search) {
        int len = myString.length();
        if (len < 1 || len > 100000) {
            // bad input, throw exception
        }
        
        int searchLen = search.length();
        if (searchLen < 1 || searchLen > 300) {
            // bad input, throw exception
        }
        
        if (!myString.matches("^[a-zA-Z]$") || !search.matches("^[a-zA-Z]$")) {
            // bad input, throw exception
        }
    }
}