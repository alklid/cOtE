import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int h = citations.length; h > 0; h--) {
            // 오름차순 정렬이기 때문에, 뒤에서 i 번째 있는 원소의 값이 i 보다 이상이면 i 번 인용된 논문의 갯수가 그만큼 있다는 것
            // 3회 이상 인용된 눈문이 3개 이상인지 검사하려면, 뒤에서 3번째 논문이 3회 이상 인용되었는지 확인
            if (citations[citations.length - h] >= h) {
                return h;
            }
        }

        return 0;
    }
}