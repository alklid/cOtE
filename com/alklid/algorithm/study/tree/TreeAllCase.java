package alklid.algorithm.study.tree;

import alklid.structure.Tree;
import alklid.structure.node.Node;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 이진검색 트리가 있다.
 * 이 이진검색 트리를 만드는 모든 경우의 수를 찾아 배열로 반환해라.
 *
 * Solution
 * Root 를 시작으로 왼쪽/오른쪽은 순서를 보장하지 않아도 되지만
 * 왼쪽은 0->1, 오른쪽은 3->4 의 순서를 각 보장해야 함.
 * 따라서 왼쪽/오른쪽은 어느것을 먼저 시작하던, 각 한쪽의 순서를 보장하는
 * 모든 경우의 수를 찾으면 됨.
 * 2 - (0)->(1)
 *   - (3)->(4)
 */

/*
   (2)
  /   \
 (0)  (3)
   \    \
   (1)  (4)

20134
20314
20341
23014
23041
23401
 */

/**
 * 만약 중간에 가지가 하나 더 있다면, 그 가지에서 다시 경우의 수를 구해야 한다.
 * 2 - (0)->(1)
 *   - (4)->(3), (4)->(5)
 *
 */
/*
    (2)
    /  \
   /    \
 (0)    (4)
   \    /  \
   (1) (3) (5)
 */
public class TreeAllCase {
    public static void main(String[] args) {
        Tree tree = new Tree(5);

        TreeAllCase treeAllCase = new TreeAllCase();
        ArrayList<LinkedList<Integer>> results = treeAllCase.allSequences(tree.root);
        for (LinkedList<Integer> result : results) {
            for (Integer data : result) {
                System.out.print(data);
            }
            System.out.println();
        }
    }


    private ArrayList<LinkedList<Integer>> allSequences(Node node) {
        ArrayList<LinkedList<Integer>> results = new ArrayList<>();
        if (node == null) {
            results.add(new LinkedList<>());
            return results;
        }

        // 배열의 경우의 수 중에 가장 앞쪽에 들어갈 노드.
        // 재귀 수행하면서 경우의 수중에 앞에 있는 노드가 먼저 Prefix 사용됨.
        // 첫 시작은 Root 노드.
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);

        // 왼쪽 노드의 순서가 보장되어야 하는 자식 노드 리스트
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);

        // 오른쪽 노드의 순서가 보장되어야 하는 자식 노드 리스트
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        // 순서가 보장된 자식 노드를 모두 교차하면서 모든 경우의 수를 구함
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                // 모든 경우의 수를 담을 배열 선언
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();

                // 왼쪽 경우의 수, 오른쪽 경우의 수, 결과 담을 배열, 임시저장공간
                weaveLists(left, right, weaved, prefix);

                // 경우의 수를 최종 결과에 넣음
                results.addAll(weaved);
            }
        }

        return results;
    }

    // 왼쪽 노드 경우의 수와 오른쪽 노드 경우의 수를 가지고 모든 조합을 만들어서
    // weaved 결과에 넣는 재귀 함수
    private void weaveLists(LinkedList<Integer> first,
                            LinkedList<Integer> second,
                            ArrayList<LinkedList<Integer>> results,
                            LinkedList<Integer> prefix) {
        // 둘중에 하나라도 없으면 결과를 반환할 시점
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = new LinkedList<>();

            // prefix 는 양쪽 노드에서 경우의 수를 만들기 위해, 하나씩 가져다가 담아놓았던 임시 저장소
            // 결과를 반환할 시점에 임시저장소의 노드들을 결과에 넣음
            for (int data : prefix) {
                result.add(data);
            }

            // 둘중 남은 노드를 모두 결과에 넣음
            result.addAll(first);
            result.addAll(second);

            // 조합 결과를 최종 결과에 넣음
            results.add(result);

            // 재귀호출 종료
            return;
        }

        // 첫번째 파이프를 기준으로 시작해서 경우의 수를 확인
        // 첫번째 파이프에서 앞쪽 노드를 prefix 에 넣고, 남은 것들로 경우의 수를 확인하도록 재귀 호출
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);

        // 두번째 파이프 기준 시작하기 전에, 첫번째 파이프를 원복
        prefix.removeLast();
        first.addFirst(headFirst);

        // 두번째 파이프를 기준으로 시작해서 경우의 수를 확인
        // 두번째 파이프에서 앞쪽 노드를 prefix 에 넣고, 남은 것들로 경우의 수를 확인하도록 재귀 호출
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);

        // 두번째 파이프 원복
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
