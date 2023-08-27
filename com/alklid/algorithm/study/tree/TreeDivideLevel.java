package alklid.algorithm.study.tree;

import alklid.structure.Tree;
import alklid.structure.node.Node;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 이진트리의 노드들을 각 레벨별로 LinkedList 에 담는 알고리즘을 구현.
 * 예를 들어, 5개의 깊이를 가지는 트리라면 5개의 LinkedList 를 만들어야 함
 *
 * Solution #1 : 시간 O(N), 공간 O(N) + O(logN)
 * 노드가 호출받을 때 몇 번 째 레벨인지를 함수의 인자로 받음.
 * 루트는 0으로 초기화해서 호출, 자식 노드를 호출할 때 자신의 레벨(0)+1 해서 넘김.
 *
 * Solution #2 : 시간 O(N), 공간 O(N)
 * 루트 노드를 1번 LinkedList 에 넣음
 * 1번 LinkedList 를 순회하면서 자식들을 2번 LinkedList 에 넣음
 * 2번 LinkedList 를 순회하면서 자식들을 3번 LinkedList 에 넣음
 * 계속 반복..
 */
/*
0,1,2,3,4,5,6,7,8,9

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
public class TreeDivideLevel {

    public Tree tree;

    private void printList(ArrayList<LinkedList<Node>> lists) {
        for (LinkedList<Node> list : lists) {
            for (Node node : list) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

    /*****************************
     * Solution #1
     *****************************/
    private ArrayList<LinkedList<Node>> BSTtoList1() {
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();
        BSTtoListR(tree.root, lists, 0);
        return lists;
    }

    private void BSTtoListR(Node root,
                            ArrayList<LinkedList<Node>> lists,
                            int level) {
        if (root == null) return;

        LinkedList list;
        if (lists.size() == level) { //만들어진적 없는 리스트
            list = new LinkedList();
            lists.add(list);
        }
        else {
            list = lists.get(level);
        }
        list.add(root);

        BSTtoListR(root.left, lists, level+1);
        BSTtoListR(root.right, lists, level+1);
    }

    /*****************************
     * Solution #2
     *****************************/
    public ArrayList<LinkedList<Node>> BSTtoList2() {
        ArrayList<LinkedList<Node>> result = new ArrayList<>();
        LinkedList<Node> current = new LinkedList<>();

        if (tree.root != null) {
            current.add(tree.root);
        }

        while (current.size() > 0) {
            result.add(current);
            LinkedList<Node> child = new LinkedList<>();
            for (Node p : current) {
                if (p.left != null) child.add(p.left);
                if (p.right != null) child.add(p.right);
            }
            current = child;
        }

        return result;
    }


    public static void main(String[] args) {
        TreeDivideLevel divideLevel = new TreeDivideLevel();
        divideLevel.tree = new Tree(10);

        divideLevel.printList(divideLevel.BSTtoList1());
        System.out.println("------------");
        divideLevel.printList(divideLevel.BSTtoList2());
    }

}
