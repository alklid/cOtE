package alklid.algorithm.practice.engineerkorea.arraystring;

/**
 * 2차원 배열에서 0으로 표기된 위치의 해당 행과 열을 모두 0으로 변경
 */
public class Array2DReplace {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 0},
            {1, 0, 1, 1}
        };
        solution(arr);

        int[][] arr2 = {
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 0, 1, 1}
        };
        solution(arr2);
    }

    private static void solution(int[][] arr) {
        print(arr);
        replace(arr);
        print(arr);
    }

    /**
     * 1. Find 0
     * 2. Store the locations
     * 3. Set rows & cols to 0, except first cols of 0
     * 4. Set info col to 0
     */
    private static void replace(int[][] arr) {
        int fr = -1;
        int fc = -1;

        for (int row=0; row<arr.length; row++) {
            for (int col=0; col<arr.length; col++) {
                if (arr[row][col] == 0) {
                    if (fc == -1) {
                        fr = row; //2
                        fc = col; //3
                    }
                    else {
                        arr[fr][col] = 0;
                        arr[row][fc] = 0;
                    }
                }
            }
        }

        for (int i=0; i<arr.length; i++) {
            if (fc != i) {
                replaceCol(arr, fr, i);
            }
        }

        for (int i=0; i<arr.length; i++) {
            replaceRow(arr, i, fc);
        }

        replaceCol(arr, fr, fc);
    }

    private static void replaceCol(int[][] arr, int row, int col) {
        if (arr[row][col] == 0) {
            for (int i=0; i<arr.length; i++) {
                arr[i][col] = 0;
            }
        }
    }

    private static void replaceRow(int[][] arr, int row, int col) {
        if (arr[row][col] == 0) {
            for (int i=0; i<arr.length; i++) {
                arr[row][i] = 0;
            }
        }
    }

    private static void print(int[][] image) {
        for (int row=0; row<image.length; row++) {
            for (int col=0; col<image.length; col++) {
                System.out.print(image[row][col]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
