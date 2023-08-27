package alklid.algorithm.study.tree;

import alklid.structure.Tree;
import alklid.structure.node.Node;

/**
 * 이진검색트리에서 주어진 노드의 다음노드를 찾는 함수를 구현하시오.
 * 단, 다음노드의 순서는 InOrder traverse 에 입각함.
 *
 * InOrder : left root right 순서
 * - 만약 오른쪽 자식노드가 있다면, 아래에 있음
 *   - 오른쪽 자식노드에서 다시 InOrder 에 입각해서 다음 노드를 계속 찾아야 함.
 * - 만약 오른쪽 자식노드가 없다면, 위에 있음
 *   - 오른쪽 자식노드가 없다면, 해당 노드의 끝까지 간것, 따라서 다시 부모에게 돌아감
 *   - 이때 내가 부모의 왼쪽인지, 오른쪽인지 알아야 함
 *     - 왼쪽 자식이었다면, 부모가 다음 순서임
 *     - 오른쪽 자식이었다면, 부모의 부모에게 가서 다시 왼쪽/오른쪽 인지 계속 찾아야 함.
 *
 * InOrder 를 모두 순회하면서 배열에 넣고 찾아도 되나..
 * 이건 트리의 수가 많을 수록 비효율적
 */
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
public class SearchNextNode {
    public Tree tree;

    private void findNext(Node node) {
        Node findNode = null;

        // 오른쪽 노드가 없으면 위쪽으로 검색
        if (node.right == null) {
            findNode = findAbove(node.parent, node);
        }

        // 오른쪽 노드가 있으면 아래쪽으로 검색
        else {
            findNode = findBelow(node.right);
        }

        System.out.println(findNode.data + " is " + node.data + "'s next");
    }

    private Node findAbove(Node root, Node child) {
        if (root == null) return null;

        // 내가 부모의 왼쪽이면 부모노드를 반환 left -> root -> right 이니까
        if (root.left == child) return root;

        // 아니면 계속 위로 보내면서 찾음
        return findAbove(root.parent, root);
    }

    private Node findBelow(Node root) {
        // 아래쪽으로는 더 이상 왼쪽 노드가 없을 때, 해당 노드가 다음 노드임.
        if (root.left == null) return root;
        return findBelow(root.left);
    }


    public static void main(String[] args) {
        SearchNextNode searchNextNode = new SearchNextNode();
        searchNextNode.tree = new Tree(10, null);

        searchNextNode.findNext(searchNextNode.tree.root.left.right.right); // 3 -> 4
        searchNextNode.findNext(searchNextNode.tree.root.left); // 1 -> 0
        searchNextNode.findNext(searchNextNode.tree.root); // 4 -> 5
        searchNextNode.findNext(searchNextNode.tree.root.left.left); // 0 -> 1
        searchNextNode.findNext(searchNextNode.tree.root.right.right); // 8 -> 9
        searchNextNode.findNext(searchNextNode.tree.root.right.left.right); // 6 -> 7
    }
}
