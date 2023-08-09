class Solution {
    
    private static String[] STR_MATCH = new String[]{"zero", "one","two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static String[] NUM_MATCH = new String[]{"0", "1","2", "3", "4", "5", "6", "7", "8", "9"};
        
    public long solution(String numbers) {
        for (int i=0; i<STR_MATCH.length; i++) {
            numbers = numbers.replace(STR_MATCH[i], NUM_MATCH[i]);
        }
        
        return Long.valueOf(numbers);
    }
}