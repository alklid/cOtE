import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        Map<Integer, Double> avg = new HashMap<>();
        
        for (int i=0; i<score.length; i++) {
            avg.put(i, (score[i][0] + score[i][1]) / 2.0);
        }
        
        // 점수 내림차순으로 정렬
        List<Integer> keySet = new ArrayList<>(avg.keySet());
        keySet.sort((a1, a2) -> avg.get(a2).compareTo(avg.get(a1)));
        
        int[] answer = new int[score.length];
        
        int level = 0;
        double prevAvg = -1;
        int equalAvgCnt = 1;
        for (Integer key : keySet) {
            if (prevAvg == avg.get(key)) {
                answer[key] = level;
                equalAvgCnt++;
            } else {
                level += equalAvgCnt;
                answer[key] = level;
                equalAvgCnt = 1;
            }
            prevAvg = avg.get(key);
        }

        return answer;
    }
}