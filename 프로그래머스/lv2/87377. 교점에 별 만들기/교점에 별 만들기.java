import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }


    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        // 교차점 구하기
        double x = (double) ((b1 * c2) - (c1 * b2)) / ((a1 * b2) - (b1 * a2));
        double y = (double) ((c1 * a2) - (a1 * c2)) / ((a1 * b2) - (b1 * a2));

        // 교차점 중에서 정수인 교차점만 반환
        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long)x, (long)y);
    }


    private Point findMinPoint(List<Point> pointList) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point point : pointList) {
            if (point.x < x) x = point.x;
            if (point.y < y) y = point.y;
        }

        return new Point(x, y);
    }


    private Point findMaxPoint(List<Point> pointList) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point : pointList) {
            if (point.x > x) x = point.x;
            if (point.y > y) y = point.y;
        }

        return new Point(x, y);
    }
    
    
    public String[] solution(int[][] line) {
        List<Point> intersectionPointList = new ArrayList<>();

        // line 반복해서 교차점 찾기
        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                Point intersectionPoint = intersection(
                    line[i][0], line[i][1], line[i][2],
                    line[j][0], line[j][1], line[j][2]);

                if (intersectionPoint != null) {
                    intersectionPointList.add(intersectionPoint);
                }
            }
        }

        // 교차점중에서 최대/최소 x,y 교차점 구하기
        Point minPoint = findMinPoint(intersectionPointList);
        Point maxPoint = findMaxPoint(intersectionPointList);

        // 최대/최소 길이에 맞게 이차원 배열 만들고 (.)문자열로 채우기
        int width = (int) (maxPoint.x - minPoint.x + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 교차점에는 (*) 문자열로 변경
        for (Point p : intersectionPointList) {
            int y = (int) (maxPoint.y - p.y);
            int x = (int) (p.x - minPoint.x);
            arr[y][x] = '*';
        }

        // 문자열 배열로 반환
        String[] answer = new String[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }

        return answer;
    }
}