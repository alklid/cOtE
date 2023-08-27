package alklid.algorithm.study.array.sort;

/**
 * 앞에서 두번째 위치부터 시작해서 끝까지 반복
 * 시작위치와 그 앞에 비교해서 작은것을 앞으로 보냄 -> 이걸 제일 앞에까지 반복
 * 시간복잡도 O(n²)
 *
 * 3,2,4,1,0,5,7,6,8,9
 * ↖ 👆
 *   ↖ 👆
 *     ↖ 👆
 *
 * https://www.youtube.com/playlist?list=PLOmdoKois7_FK-ySGwHBkltzB11snW7KQ
 */
public class InsertionSort {
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
        sorted(arr, 1);
        print(arr);
    }

    private static void sorted(int[] arr, int s) {
        if (s < arr.length) {
            for (int i=s; i>0; i--) {
                if (arr[i] < arr[i-1]) {
                    swap(arr, i, i-1);
                }
            }
            sorted(arr, s+1);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
