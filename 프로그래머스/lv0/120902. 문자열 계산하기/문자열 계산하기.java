class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.split(" ");
        int answer = 0;
        for (int i=1; i<arr.length; i=i+2) {
            if ("+".equals(arr[i])) {
                arr[i+1] = String.valueOf(Integer.parseInt(arr[i-1]) + Integer.parseInt(arr[i+1]));
            }
            else {
                arr[i+1] = String.valueOf(Integer.parseInt(arr[i-1]) - Integer.parseInt(arr[i+1]));
            }
        }
        return Integer.parseInt(arr[arr.length-1]);
    }
}