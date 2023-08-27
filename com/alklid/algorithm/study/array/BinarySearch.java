package alklid.algorithm.study.array;

public class BinarySearch {
    /*
    이진탐색(binary search)
      - 실행시간은 빅오 표기법을 사용
        - O(log n) : 로그시간, binary search
        - O(n) : 선형시간, simple search
        - O(n * log n) : quick sort
        - O(n*n) : selection sort
        - O(n!) : traveling salesperson problem
    */

    // list 배열에서 item 에 해당하는 원소가 배열의 몇번째 인덱스에 있는지를 찾음.
    private int binary_search(int[] arr, int item) {
        int low, mid, high, guess;

        low = 0;
        high = arr.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            guess = arr[mid];

            if (guess == item)
                return mid;

            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] arg) {
        BinarySearch test = new BinarySearch();

        System.out.println(test.binary_search(new int[]{1,2,3,4,5}, 3));
        System.out.println(test.binary_search(new int[]{1,3,5,7,9}, -1));
    }
}
