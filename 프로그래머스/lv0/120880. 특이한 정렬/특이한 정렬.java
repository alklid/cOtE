class Solution {
    public int[] solution(int[] numlist, int n) {
        for (int i=0; i<numlist.length-1; i++) {
            int minDiff = Math.abs(numlist[i]-n);
            
            for (int j=i+1; j<numlist.length; j++) {
                if (Math.abs(numlist[j] - n) < minDiff) {
                    minDiff = Math.abs(numlist[j] - n);
                    swap(numlist, j, i);
                }
                
                if (i-1 > 0) {
                    if (Math.abs(numlist[i-1] - n) == Math.abs(numlist[i] - n) && numlist[i-1] < numlist[i]) {
                        swap(numlist, i-1, i);
                    }    
                }
            }
        }
        return numlist;
    }
    
    public void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}