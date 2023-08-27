package alklid.algorithm.practice.engineerkorea.arraystring;

/**
 * 2차원 배열을 90도 회전하라. 단, 다른 자료형은 사용하지 않음.
 *
 * Layer 별로 회전
 *  Layer 1 -> s = 0, e = 4
 *  Layer 2 -> s = 1, e = 3
 *  ==> pattern : s++, e--
 *
 * Layer 내에서의 Loop
 *  i = s to i=e
 *    i = 1, 2, 3
 *  j = e to j=s (아래쪽의 배열은 반대로 Loop)
 *    j = 3, 2, 1
 *
 *  Layer2 : s=1, e=3
 *  Loop : i=1,2,3 / j=3,2,1
 *   Top 배열들 : [s][i]
 *   Right 배열들 : [i][e]
 *   Bottom 배열들 : [e][j]
 *   Left 배려들 : [j][s]
 *
 *  옮기는 순서
 *  tmp = Top       -> tmp = [s][i]
 *  Top = Right     -> [s][i] = [i][e]
 *  Right = Bottom  -> [i][e] = [e][j]
 *  Bottom = Left   -> [e][j] = [j][s]
 *  Left = tmp      -> [j][s] = tmp
 */
public class Array2DRotate {
    public static void main(String[] args) {
        int[][] image = {
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
        };
        solution(image);
    }

    private static void solution(int[][] image) {
        print(image);
        rotate(image);
        print(image);
        rotate(image);
        print(image);
        rotate(image);
        print(image);
        rotate(image);
        print(image);
    }

    private static void rotate(int[][] image) {
        for (int s=0, e=image.length-1; s < e; s++, e--) {
            for (int i=s, j=e; i < e; i++, j--) {
                int tmp = image[s][i];
                image[s][i] = image[i][e];
                image[i][e] = image[e][j];
                image[e][j] = image[j][s];
                image[j][s] = tmp;
            }
        }
    }

    private static void print(int[][] image) {
        for (int i=0; i<image.length; i++) {
            for (int j=0; j<image.length; j++) {
                System.out.print(image[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
