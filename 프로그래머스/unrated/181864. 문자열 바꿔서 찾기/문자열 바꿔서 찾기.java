class Solution {
    public int solution(String myString, String pat) {
        validation(myString, pat);
        
        StringBuffer sb = new StringBuffer();
        for (char ch : myString.toCharArray()) {
            if (ch == 'A') {
                sb.append("B");
            }
            else {
                sb.append("A");
            }
        }
        String reverse = sb.toString();
        
        int answer = (reverse.indexOf(pat) != -1) ? 1 : 0;
        return answer;
    }
    
    static void validation(String myString, String search) {
        int len = myString.length();
        if (len < 1 || len > 100) {
            // bad input, throw exception
            System.out.println("exception case1");
        }
        
        int searchLen = search.length();
        if (searchLen < 1 || searchLen > 10) {
            // bad input, throw exception
            System.out.println("exception case2");
        }
        
        if (!myString.matches("^[AB]*$") || !search.matches("^[AB]*$")) {
            // bad input, throw exception
            System.out.println("exception case3");
        }
    }
}