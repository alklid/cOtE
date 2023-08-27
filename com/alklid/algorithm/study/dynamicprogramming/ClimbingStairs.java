package alklid.algorithm.study.dynamicprogramming;

import java.util.Stack;

/**
 * 최소 비용으로 계단 오르기
 *
 * cost[] 배열의 인덱스를 계단이라고 보고, 해당 배열의 값에는 해당 계단을 오르는데 필요한 비용이 들어있음.
 * 계단은 1칸 또는 2칸을 오를 수 있고, 맨 처음 시작은 배열의 0 또는 1에서 선택할 수 있음.
 * 계단 꼭대기까지 오르기 위해서 필요한 최소로 비용을 구하라.
 *
 * example 1)
 * input : cost = [10, 15, 20]
 * output : 15
 *
 * example 2)
 * input : cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * output : 6
 *
 *
 * Solution #1
 * 앞에서 부터 선택하는 경우를 따져보면 총 4가지 선택의 경우가 있음
 *       0  1  2  3  4  5  6
 *   1. [v][v][v][ ][ ][ ][ ] -> 이 경우는 비용대비 가장 비효율적으로 선택의 경우에서 제외
 *   2. [v][v][ ][v][ ][ ][ ]
 *   3. [v][ ][v][v][ ][ ][ ]
 *   4. [v][ ][v][ ][v][ ][ ]
 * 하지만, 앞에서 부터 선택하는 경우를 고려하려면,
 * 마지막 선택된 계단의 그 다음 건너뛸 수 있는 계단의 비용을 고려해야만 결정할 수 있다.
 * 예를 들면, 위에서 [3] 또는 [4] 계단중 선택하려면,
 *   만약 [5] 계단의 비용이 [4] 계단보다 비싸면 [4]를 밟고 [5]를 건너뛰는게 최소비용이고
 *   만약 [4] 계단이 [5][6] 보다 비싸면 [3] 에서 [5]로 가는게 최소비용임.
 * 이처럼 현재 계단을 밟아야 하는 여부를 선택하려면, 뒤쪽의 계단을 모두 알아야 선택할 수 있는데
 * 이런 방식의 경우, 첫 선택 [0] 또는 [1] 부터 해서 각 선택지마다 이후의 모든 계단의 비용을 재귀함수를 통해 확인해야 함
 *
 * Solution #2
 * 이 경우, 앞에서 부터 고려하기보다는 뒤에서 부터 계산해나가는 방식을 사용하여 해결.
 * 최종 도착지를 시작으로 한칸 또는 두칸 앞에서 현재까지의 최소 비용을 해당 배열의 최소 비용에 임시 저장하고
 * 최소 비용을 가리키는 배열을 시작으로서 한칸 또는 두칸 앞에서 현재까지의 최소 비용을 찾는 과정을 배열의 시작까지 반복해서
 * 앞에서 한칸 또는 두칸 이후의 계단을 밟을지 말지 결정할 수 있도록 미리 최소 비용을 계산해 놓도록 함.
 * 결국 배열의 [0] 또는 [1] 에서 최종 도착지까지의 최소 비용을 알 수 있음.
 *                 [ 1][ 2][ 3][ 4][ 5][ 6][ 7]
 * minCost(mc)     [13][12][13][10][11][ 6][ 7]
 * minCost choose  [7] => [7] -> 도착지까지 7이 최소 비용
 *                 [6] => [6] -> 도착지까지 6이 최소 비용
 *                 [5] => [min(mc[6] => 6, mc[7] => 7) => 6 + 5 => 11] -> 도착지까지 11이 최소 비용(5 -> 6)
 *                 [4] => [min(mc[5] => 11, mc[6] => 6) => 6 + 4 => 10] -> 도착지까지 10이 최소 비용(4 -> 6)
 *                 [3] => [min(mc[4] => 10, mc[5] => 11) => 10 + 3 => 13] -> 도착지까지 13이 최소 비용(3 -> 4 -> 6)
 *                 [2] => [min(mc[3] => 13, mc[4] => 10) => 10 + 2 => 12] -> 도착지까지 12이 최소 비용(2 -> 4 -> 6)
 *                 [1] => [min(mc[2] => 12, mc[3] => 13) => 12 + 1 => 13] -> 도착지까지 13이 최소 비용(1 -> 2 -> 4 -> 6)
 */
public class ClimbingStairs {
    // 최소 비용
    public static int minCostClimbingStairs(int[] cost) {
        // 1칸 다음을 밟을 경우의 최소 비용
        int case1 = 0;

        // 2칸 다음을 밟을 경우의 최소 비용
        int case2 = 0;

        int current;
        for (int i = cost.length-1; i >= 0; i--) {
            // 현재 계단을 밟을 경우의 최소 비용
            current = cost[i] + Math.min(case1, case2);
            case2 = case1;
            case1 = current;
        }

        return Math.min(case1, case2);
    }

    // 최소 비용의 경로
    public static void minCostPathClimbingStairs(int[] cost) {
        Stack<Integer> minCostPathStack = new Stack<>();

        // 각 계단에서 목적지까지의 최소 비용
        int[] totalCost = new int[cost.length];

        // 1칸 다음 계단의 인덱스
        int case1Stair = 0;

        // 2칸 다음 계단의 인덱스
        int case2Stair = 0;

        for (int i = cost.length-1; i >= 0; i--) {
            totalCost[i] = cost[i] + Math.min(totalCost[case1Stair], totalCost[case2Stair]);
            case2Stair = case1Stair;
            case1Stair = i;

            // 마지막에서 2번째까지는 어느 계단을 밟을지 결정할 수 없음.
            if (i <= cost.length-3) {
                addPath(minCostPathStack, totalCost, i);
            }
        }

        // 맨 처음에서 첫번째 또는 두번째 계단 중 선택
        addPath(minCostPathStack, totalCost, -1);

        // 경로 출력
        if (minCostPathStack.isEmpty()) {
            System.out.println("Not Found Path");
        }
        else {
            while(!minCostPathStack.isEmpty()) {
                System.out.print(minCostPathStack.pop() + " ");
            }
            System.out.println();
        }
    }


    private static void addPath(Stack<Integer> minCostPathStack, int[] totalCost, int stair) {
        int minPath;

        // 현재 계단에서 한칸 또는 두칸중 어느 계단이 최소 비용인지 선택
        if (totalCost[stair+1] > totalCost[stair+2]) {
            minPath = stair+2;
        }
        else {
            minPath = stair+1;
        }

        if (minCostPathStack.isEmpty()) {
            minCostPathStack.push(minPath);
            return;
        }

        if (minCostPathStack.peek() != minPath) {
            minCostPathStack.push(minPath);
        }
    }


    public static void main(String[] args) {
        int[] cost = new int[]{1, 2, 3, 4, 5, 6, 7};
        minCostPathClimbingStairs(cost);
        int result = minCostClimbingStairs(cost);
        System.out.println(result);

        cost = new int[]{10, 15, 20};
        minCostPathClimbingStairs(cost);
        result = minCostClimbingStairs(cost);
        System.out.println(result);

        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        minCostPathClimbingStairs(cost);
        result = minCostClimbingStairs(cost);
        System.out.println(result);
    }
}
