import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    
    private static final int[][] ANSWER_PATTERN = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
    };
    
    public int[] solution(int[] answers) {
        int[] point = new int[3];
        int topPoint = 0;

        for (int q=0; q<answers.length; q++) {
            // 문제의 정답
            int answer = answers[q];

            // 각 학생별로 정답 여부 확인
            for (int s=0; s<3; s++) {
                if (answer == getAnswer(s, q)) {
                    point[s]++;

                    // 최고 점수 갱신
                    topPoint = Math.max(point[s], topPoint);
                }
            }
        }

        int finalTopPoint = topPoint;
        return IntStream.range(0, 3)
                        .filter(s -> point[s] == finalTopPoint)
                        .map(i -> i + 1).toArray();
    }
    
    private int getAnswer(int student, int question) {
        int[] pattern = ANSWER_PATTERN[student];
        int idx = question % pattern.length;
        return pattern[idx];
    }
}