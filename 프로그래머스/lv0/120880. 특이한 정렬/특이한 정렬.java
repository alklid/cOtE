/**
* SelectionSort, 이중 loop 사용해서 정렬
* 기준을 특정 수와 거리가 가까운 순서, 거리가 같아면 더 큰 수를 앞에 오도록 정렬
**/
class Solution {
    public int[] solution(int[] numlist, int n) {
        /*
        // Stream 이용 방식
        return Arrays.stream(numList)
                .boxed()
                .sorted((a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
                .mapToInt(Integer::intValue)
                .toArray();
        */
        
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