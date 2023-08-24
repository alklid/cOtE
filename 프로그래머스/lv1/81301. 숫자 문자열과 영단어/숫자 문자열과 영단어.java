class Solution {
    
    private static String[] words = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public int solution(String s) {
        for (int i=0;i< words.length; i++) {
            s = s.replace(words[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }
}