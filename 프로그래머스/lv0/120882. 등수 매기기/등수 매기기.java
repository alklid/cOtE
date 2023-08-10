import java.util.*;

/**
* 점수별 등수를 매기는데, 같은 점수는 같은 등수로 설정
**/
class Solution {
    public int[] solution(int[][] score) {
        // indexOf 로 동일한 경우 작은 수가 나오는 것을 응용하는 방식
        List<Integer> scoreList = new ArrayList<>();
        for(int[] t : score){
            scoreList.add(t[0] + t[1]);
        }
        scoreList.sort(Comparator.reverseOrder());

        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            answer[i] = scoreList.indexOf(score[i][0] + score[i][1])+1;
        }
        return answer;
        
        /*
        // 등수를 수동으로 계산하는 방식
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
        */
    }
}