package alklid.algorithm.study.array.sort;

/**
 * 퀵 정렬의 시간복잡도 O(n log n), 최악의 경우 O(n²)
 * 별도의 저장공간을 사용하지 못하는 경우는 퀵 정렬
 *
 * https://www.youtube.com/playlist?list=PLOmdoKois7_FK-ySGwHBkltzB11snW7KQ
 */
public class QuickSort {
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
        sorted(arr, 0, arr.length-1);
        print(arr);
    }

    /**
     * 배열의 중간위치에 있는 값을 기준값으로 설정하고 파티셔닝
     * 파티셔닝
     *  앞에서 부터는 기준값보다 작으면 무시하고 다음으로 넘어감 -> 크면 스왑대상이니까 멈춤
     *  뒤에서 부터는 기준값보다 크면 무시하고 다음으로 넘어감 -> 작으면 스왑대상이니까 멈춤
     *  멈춰진 대상끼리 스왑시키고, 다시 시작
     *  계속 하다보면 앞에서 부터 시작한것과, 뒤에서 부터 시작한게 지나쳐버린 시점이 있음.
     *  지나쳐버린 시점에서 앞에서 부터 시작한 인덱스 위치가 파티셔닝 기준 -> 이걸 반환
     * 파티셔닝된걸 각각 재귀처리
     */
    private static void sorted(int[] arr, int s, int e) {
        // 오른쪽 파티션의 첫번째 시작 위치(인덱스)
        int part2 = partition(arr, s, e);

        // 왼쪽 파티션의 시작 위치가 왼쪽 파티션 마지막 시작 위치보다 작으면,
        // 왼쪽 파티션 재귀처리
        if (s < part2-1) {
            sorted(arr, s, part2-1);
        }

        // 오른쪽 파티션의 끝 위치가 오른쪽 파티션의 시작 위치보다 크면,
        // 오른쪽 파티션 재귀처리
        if (part2 < e) {
            sorted(arr, part2, e);
        }
    }

    private static int partition(int[] arr, int s, int e) {
        int pivot = arr[(s+e) / 2]; // 중간 위치값을 기준

        while (s <= e) {
            while (arr[s] < pivot) s++; // 시작지점 부터는 기준값보다 작으면 무시
            while (arr[e] > pivot) e--; // 끝 지점 부터는 기준값보다 크면 무시
            if (s <= e) {
                swap(arr, s, e);
                s++;
                e--;
            }
        }

        return s; // 두 개의 값이 만나서 지나치는 시점에서 두번째 파티션의 시작 위치값
    }

    private static void swap(int[] arr, int s, int e) {
        int tmp = arr[s];
        arr[s] = arr[e];
        arr[e] = tmp;
    }
}
