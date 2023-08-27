package alklid.algorithm.study.array.sort;

/**
 * 시간복잡도 O(n log n)
 * 별도의 저장공간을 사용해야 함.
 *
 * 2개의 정렬된 리스트를 합병(merge)하는 과정
 * 1. 2개의 리스트의 값들을 처음부터 하나씩 비교하여
 *    두 개의 리스트의 값 중에서 더 작은 값을 새로운 리스트(sorted)로 옮긴다.
 * 2. 둘 중에서 하나가 끝날 때까지 이 과정을 되풀이한다.
 * 3. 만약 둘 중에서 하나의 리스트가 먼저 끝나게 되면
 *    나머지 리스트의 값들을 전부 새로운 리스트(sorted)로 복사한다.
 * 4. 새로운 리스트(sorted)를 원래의 리스트(list)로 옮긴다.
 *
 * https://www.youtube.com/playlist?list=PLOmdoKois7_FK-ySGwHBkltzB11snW7KQ
 */
public class MergeSort {
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
        int[] tmp = new int[arr.length];
        sorted(arr, tmp, 0, arr.length-1);
        print(arr);
    }

    /**
     * 1. 배열을 둘로 계속 나눔, 총 2개(파티션이 딱 1개일때)까지 나눔.
     * 2. 파티셔닝이 끝나면 merge 를 사용해서 병합함
     */
    private static void sorted(int[] arr, int[] tmp, int s, int e) {
        if (s < e) {
            int m = s + (e-s)/2;
            sorted(arr, tmp, s, m);
            sorted(arr, tmp, m+1, e);
            merge(arr, tmp, s, m, e);
        }
    }

    private static void merge(int[] arr, int[] tmp, int s, int m, int e) {
        // 임시저장소에 정렬이 필요한 만큼 복사해줌
        for (int i=s; i<=e; i++) {
            tmp[i] = arr[i];
        }

        // 각 파티셔닝의 시작 위치 설정
        int part1 = s;
        int part2 = m+1;

        // 결과 배열이 저장될 위치
        int index = s;

        // 각 파티션이 끝까지 갈때까지 수행
        while (part1 <= m && part2 <= e) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            }
            else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }

        // 만약 앞쪽 파티션이 남아 있으면 남은 것들은 붙여줌
        for (int i=0; i<=m-part1; i++) {
            arr[index+i] = tmp[part1+i];
        }

        // 만약 뒤쪽 파티션이 남아 있으면, 그건 최종 배열에 이미 있는거라서 추가 필요없음
    }
}
