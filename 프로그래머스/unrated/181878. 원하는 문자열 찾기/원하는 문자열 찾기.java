class Solution {
    public int solution(String myString, String pat) {
        validation(myString, pat);
        
        int answer = (myString.toLowerCase().indexOf(pat.toLowerCase()) != -1) ? 1 : 0;
        return answer;
    }
    
    static void validation(String myString, String search) {
        int len = myString.length();
        if (len < 1 || len > 100000) {
            System.out.println("exception");
        }
        
        int searchLen = search.length();
        if (searchLen < 1 || searchLen > 300) {
            System.out.println("exception");
        }
        
        if (!myString.matches("^[a-zA-Z]*$") || !search.matches("^[a-zA-Z]*$")) {
            System.out.println("exception");
        }
    }
}