import java.util.Arrays;

class Solution {
    public int solution(String s) {
        String[] arr = s.split(" ");
        for (int i=0; i<arr.length; i++) {
            if ("Z".equals(arr[i])) {
                arr[i] = "0";
                arr[i-1] = "0";
            }
        }
        
        return Arrays.stream(arr).mapToInt(v -> Integer.parseInt(v)).sum();
    }
}