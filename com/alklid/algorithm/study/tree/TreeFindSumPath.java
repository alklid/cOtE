package alklid.algorithm.study.tree;

import alklid.structure.Tree;
import alklid.structure.node.Node;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 주어진 이진트리가 있고, 이 트리의 노드에는 정수값이 저장되어 있다. (음의 정수 포함)
 * 연결된 노드의 합산이 특정 숫자가 되는 경로의 갯수를 찾으시오.
 * 경로의 시작과 끝점은 어디든 될 수 있지만 언제나 위에서 아래로만 합산이 되어야 함.
 *
 * Solution #1
 * 시작지점노드 부터 PreOrder 순으로 조회해가면서 합산의 값인지를 확인하는 재귀함수를 호출
 * 합산의 값이 맞으면 경로를 하나 찾은거니까 1을 증가 시켜서(없으면 0) 상위노드에 반환.
 * 최종적으로 시작지점노드 에서는 양쪽 자식노드로부터 반환된 경로의 합을 반환.
 * 이걸 시작지점노드의 left, right 를 내려가면서 시작지점으로 사용해서 계속 재귀적으로 계산
 * 경로의 시작과 끝점이 어디든 될 수 있으니, Root 에서는 양쪽 노드를 모두 순회.
 * Root 의 왼쪽 노드에서 시작하면 왼쪽만 순회. Root 의 오른쪽 노드에서 시작하면 오른쪽만 순회.
 * 따라서 시간복잡도 O(n log n) 처럼 보이지만, 최악의 경우 한쪽에 노드가 쏠려있으면 모든 노드를 중복 순회하니 O(n²)
 *
 *
 * Solution #2
 * Solution #1 에서는 각 노드를 순회할때마다 하위 서브 트리를 다시 중복해서 검색하는 단점이 있음.
 * 추가 저장공간을 이용(memoization)해서 한번만 계산하고 이를 이용하도록 처리.
 * 배열을 만들고, 노드를 순회하면서 각 배열에 합산하고, 순회시마다 배열에서 원하는 합산의 값이 있는지를 검색하는 방법.
 * 더 이상 노드가 없을때에는 돌아가면서, 해당 노드에 해당하는 마지막 배열을 제거하고, 그 값만큼 각 배열의 값에서 빼줌.
 * - 순회시 배열의 처리 순서 : update(+) -> add -> search(여기서 원하는 합산 값이 있는지 확인해서 총 경로의 수에 더해줌)
 *   예) 4 -> [4][][][][], 1 -> [5][1][][][], 0 -> [5][1][0][][]
 * - 부모노드로 돌아갈때의 배열의 처리 순서 : remove -> update(-)
 *   예) 0 에서 부모노드로 -> [5-0][1-0][0 -> remove 처리함][][]
 *   예) 3 에서 부모노드로 -> [10-3][6-3][5-3][3 -> remove 처리함][]
 * 배열의 크기는 트리의 깊이(d) 만큼 필요. 따라서 시간복잡도는 O(nd)
 *
 *
 * Solution #3
 * Solution #2 에서 배열을 사용하면, 매번 배열을 조회해야 하는 함.
 * 노드를 순회하면서 각 노드의 값만큼을 거리로 계산해서 Key 로 설정하고, 노드의 갯수를 Value 로 설정해서 Map 에 저장.
 * 해당 거리에서 원하는 합산의 값만큼 뺀 값에 해당하는 Key 를 가지는 노드를 조회, 있으면 노드의 갯수(value)를 총 경로의 수에 더해줌.
 * 부모 노드로 돌아갈때에는 자신의 거리만큼을 가지는 Key 를 제거하는데, 노드의 갯수(value) 를 -1 시켜서 0이되면 Key 를 제거함.
 * 예) 노드 4 -> 1 -> 0(여기서 Key(5)의 Value 가 2가 됨) -> 5
 *       K 0   45    10
 *         ----**---- *----
 *       V 1   12     1
 * 각 노드까지의 거리를 Key(노드의 거리 합산), Value(노드의 갯수) Map 을 사용하면 O(1) 로 탐색이 가능함.
 * 따라서 Map 탐색은 제외하면, 모든 노드를 1번만 순회하면 되기 때문에 시간복잡도는 O(n)
 */
public class TreeFindSumPath {
    public Tree tree;

    /*****************************
     * Solution #1
     *****************************/
    // 검색할 합산 결과값을 받으면 Root 부터 시작하는 재귀함수 호출
    private int solution1(int targetSum) {
        return countPathsWithSum(tree.root, targetSum);
    }

    // 시작지점 노드를 PreOrder 순으로 바꿔가면서 경로의 수를 구하라는 재귀 호출
    private int countPathsWithSum(Node root, int targetSum) {
        // 노드가 끝까지 가면 0 을 반환
        if (root == null) return 0;

        // 실제로 해당 노드에서부터 합산 결과값의 경로의 수를 검색하는 함수
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

        // 자식노드들을 Root 로 해서 재귀호출
        int pathsOnLeft = countPathsWithSum(root.left, targetSum);
        int pathsOnRight = countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    // 자식노드들에 현재까지의 합산값을 넘겨주면서 합산의 값이 맞는지 확인하도록 재귀 호출
    private int countPathsWithSumFromNode(Node node, int targetSum, int currSum) {
        if (node == null) return 0;

        // 현재노드의 값까지 포함해서 경로 합 계산
        currSum += node.data;

        // 모든 경로의 수를 초기화하고, 현재노드 값까지 경로 합이 원하는 값이면 증가시킴
        int totalPaths = 0;
        if (currSum == targetSum) totalPaths++;

        // 자식노드들에 현재까지의 합산값을 넘겨주면서 검색하도록 재귀 호출
        totalPaths += countPathsWithSumFromNode(node.left, targetSum, currSum);
        totalPaths += countPathsWithSumFromNode(node.right, targetSum, currSum);

        return totalPaths;
    }


    /*****************************
     * Solution #2
     *****************************/
    // memoization 에 사용할 배열을 생성하고, 이를 넘겨주면서 재귀함수 호출
    private int solution2(int targetSum) {
        ArrayList<Integer> array = new ArrayList<>();
        return countPathsWithSum(tree.root, targetSum, array);
    }

    private int countPathsWithSum(Node root, int targetSum, ArrayList<Integer> array) {
        if (root == null) return 0;
        int totalPaths = 0;

        // 순회시 배열의 처리 순서 : update(+) -> add -> search
        updateAndAddValue(array, root.data);
        totalPaths += countPaths(array, targetSum);

        // 왼쪽 노드 기준으로 재귀 호출
        totalPaths += countPathsWithSum(root.left, targetSum, array);

        // 오른쪽 노드 기준으로 재귀 호출
        totalPaths += countPathsWithSum(root.right, targetSum, array);

        // 부모노드로 돌아갈때의 배열의 처리 순서 : remove -> update(-)
        removeAndUpdate(array);

        return totalPaths;
    }

    private void updateAndAddValue(ArrayList<Integer> array, int value) {
        // 기존 배열에 value 만큼 증가시킴
        for (int i = 0; i < array.size(); i++) {
            array.set(i, array.get(i) + value);
        }

        // 배열의 마지막에 value 추가
        array.add(value);
    }

    // 배열에 원하는 합산 값의 개수를 모두 찾아서 반환
    private int countPaths(ArrayList<Integer> array, int targetSum) {
        int totalPaths = 0;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == targetSum) totalPaths++;
        }

        return totalPaths;
    }

    private void removeAndUpdate(ArrayList<Integer> array) {
        // 배열의 마지막 value 삭제
        int value = array.remove(array.size() - 1);

        // 기존 배열에 value 만큼 감소시킴
        for (int i = 0; i < array.size(); i++) {
            array.set(i, array.get(i) - value);
        }
    }


    /*****************************
     * Solution #3
     *****************************/
    // memoization 에 사용할 Map을 생성하고, 이를 넘겨주면서 재귀함수 호출
    private int solution3(int targetSum) {
        HashMap<Integer, Integer> hashTable = new HashMap<>();
        hashTable.put(0, 1);

        return countPathsWithSum(tree.root, targetSum, 0, hashTable);
    }

    private int countPathsWithSum(Node node, int targetSum, int currSum, HashMap<Integer, Integer> hashTable) {
        if (node == null) return 0;

        // 현재 노드까지의 거리의 값
        currSum += node.data;

        // 현재 노드거리 기준으로 원하는 합산의 값만큼 뺀 거리에 노드가 있는지를 Map 에서 확인하고
        // 노드가 있다면 노드수만큼을 총 경로에 증가시킴
        int findDistance = currSum - targetSum;
        int totalPaths = hashTable.getOrDefault(findDistance, 0);

        // 현재 노드거리 기준에 해당하는 Key 와 노드의 갯수를 Map 에 추가 또는 업데이트
        incrementHashTable(hashTable, currSum, 1);

        // 왼쪽 노드 기준으로 재귀 호출
        totalPaths += countPathsWithSum(node.left, targetSum, currSum, hashTable);

        // 오른쪽 노드 기준으로 재귀 호출
        totalPaths += countPathsWithSum(node.right, targetSum, currSum, hashTable);

        // 부모노드로 돌아갈때의 Map 에서 거리를 제거하는 처리
        incrementHashTable(hashTable, currSum, -1);

        return totalPaths;
    }

    private void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int count) {
        int newCount = hashTable.getOrDefault(key, 0) + count;

        // 부모노드로 돌아갈 때의 처리, -1 해서 노드의 갯수가 0 이면
        if (newCount == 0) {
            hashTable.remove(key);
        }
        else {
            hashTable.put(key, newCount);
        }
    }


    public static void main(String[] args) {
        /*
               (4)
              /   \
             /     \
            /       \
          (1)       (7)
         /   \     /   \
        (0)  (2)  (5)  (8)
               \    \    \
                (3)  (6)  (9)
         */
        TreeFindSumPath findSumPath = new TreeFindSumPath();
        findSumPath.tree = new Tree(10);

        // 5 : 4-1, 4-1-0, 2-3, 5
        System.out.println("Solution1(5) : " + findSumPath.solution1(5));
        System.out.println("Solution2(5) : " + findSumPath.solution2(5));
        System.out.println("Solution3(5) : " + findSumPath.solution3(5));

        // 3 : 1-2, 3
        System.out.println("Solution1(3) : " + findSumPath.solution1(3));
        System.out.println("Solution2(3) : " + findSumPath.solution2(3));
        System.out.println("Solution3(3) : " + findSumPath.solution3(3));
    }
}
