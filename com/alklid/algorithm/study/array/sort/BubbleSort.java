package alklid.algorithm.study.array.sort;

/**
 * 앞에서 2개씩 잡아서 정렬시키면서 끝까지 처리하면, 맨 끝에는 정렬완료된 것
 * 맨 끝을 제외하고 다시 앞에서부터 2개씩 잡아서 정렬
 * 이런식으로 처음부터 정렬완료된 위치까지 2개씩 잡아서 정렬.
 * 시간 복잡도 O(n²)
 *
 * 3,2,4,1,0,5,7,6,8,9
 * 👆↗
 *   👆↗
 *     👆↗
 *
 * https://www.youtube.com/playlist?list=PLOmdoKois7_FK-ySGwHBkltzB11snW7KQ
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4,1,0,5,7,6,8,9};
        solution(arr);

        arr = new int[]{3,9,4,7,5,0,1,6,8,2};
        solution(arr);
    }

    private static void print(int[] arr) {
        for (int x: arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    private static void solution(int[] arr) {
        print(arr);
        sorted(arr, arr.length-1);
        print(arr);
    }

    private static void sorted(int[] arr, int e) {
        if (e > 0) {
            for (int i=0; i<=e-1; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                }
            }
            sorted(arr, e-1);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
