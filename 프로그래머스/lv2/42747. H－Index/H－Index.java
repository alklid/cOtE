import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int max = 0;
        for (int i = citations.length-1; i > -1; i--) {
            // 정렬이후에 역순으로 조회하면, 해당 원소의 값 보다 큰 원소들의 갯수는 citations.length - i 와 같음.
            // 원소의 값은 점점 감소(정렬이후에 역순으로 조회)하고, 원소 값 이상인 것의 개수는 점점 감소 함.
            // 이 두 값의 최소값의 변화가 증가하다가 감소하는 지점
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}