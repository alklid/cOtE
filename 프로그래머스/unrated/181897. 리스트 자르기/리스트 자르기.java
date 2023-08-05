class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int startIdx = 0;
        int endIdx = 0;
        int interval = 1;
        
        if (n == 1) {
            startIdx = 0;
            endIdx = slicer[1];
            interval = 1;
        }
        if (n == 2) {
            startIdx = slicer[0];
            endIdx = num_list.length-1;
            interval = 1;
        }
        if (n == 3) {
            startIdx = slicer[0];
            endIdx = slicer[1];
            interval = 1;
        }
        if (n == 4) {
            startIdx = slicer[0];
            endIdx = slicer[1];
            interval = 2;
        }
        
        int len = (endIdx - startIdx + interval) / interval;
        int[] answer = new int[len];
        
        int idx = 0;
        for (int i=startIdx; i<=endIdx; i+=interval) {
            answer[idx] = num_list[i];
            idx++;
        }
        return answer;
    }
    
}