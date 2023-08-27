package alklid.algorithm.study.array.sort;

/**
 * 배열을 돌면서, 가장 작은값을 찾고 하나씩 앞으로 이동하는 정렬
 * 시간복잡도 O(n²)
 *
 * https://www.youtube.com/playlist?list=PLOmdoKois7_FK-ySGwHBkltzB11snW7KQ
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4,1,0,5,7,6,8,9};
        solution1(arr);
        arr = new int[]{3,9,4,7,5,0,1,6,8,2};
        solution1(arr);

        arr = new int[]{3,2,4,1,0,5,7,6,8,9};
        solution2(arr);
        arr = new int[]{3,9,4,7,5,0,1,6,8,2};
        solution2(arr);
    }

    // 이중 loop
    private static void solution1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }

            // 자리를 변경
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        print(arr);
    }

    // 재귀호출 방식
    private static void solution2(int[] arr) {
        sorted(arr, 0);
        print(arr);
    }

    private static void sorted(int[] arr, int s) {
        if (s < arr.length-1) {
            int minIdx = s;
            for (int i=s; i<arr.length; i++) {
                if (arr[i] < arr[minIdx]) {
                    minIdx = i;
                }
            }
            swap(arr, s, minIdx);
            sorted(arr, s+1);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }


    private static void print(int[] arr) {
        for (int x: arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
