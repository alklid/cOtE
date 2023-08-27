package alklid.algorithm.study.tree;

import alklid.structure.Tree;
import alklid.structure.node.Node;

/**
 * 주어진 이진트리의 Balance 가 맞는지 확인하는 함수를 구현
 * 여기서 Balance 가 맞다는 의미는 어떤 노드의 양쪽 서브트리의 길이가
 * 1이상 차이가 나지 않는 것을 뜻함.
 *
 * Solution #1
 * 노드마다 서브 트리의 길이를 측정하는 함수를 재귀호출
 * 함수의 결과값을 받아와서 양쪽의 서브 트리의 길이가 1 보다 크면 false 반환.
 * 시간복잡도 O(N logN) 비효율적인 = getHeight 가 노드마다 계산함.
 *
 * Solution #2
 * 루트에서 끝까지 내려간다음에 올라오면서 길이를 확인
 * 시간복잡도 O(N)
 *
 * Solution #3
 * #1,#2 의 경우 가장 긴 서브트리의 길이로는 밸런스하지만
 * 가장 짧은 서브트리와 가장 긴 서브트리의 길이차이는 언밸런스한다.
 * 따라서 이런 경우까지 밸런스에서 체크하도록 비교하는 로직.
 *
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
public class BalanceCheck {

    public Tree tree;

    public BalanceCheck(int size) {
        tree = new Tree(size);
    }

    private void makeUnBalanced(Node root) {
        root.right.right.right.right = new Node(10);
    }

    private void makeDeepUnBalanced(Node root) {
        root.right.right.left = new Node(11);
    }


    /*****************************
     * Solution #1
     *****************************/
    private boolean isBalanced(Node root) {
        if (root == null) return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        }
        else {
            // 왼쪽/오른쪽이 모두 밸런스가 맞는지 확인
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    // 서브트리까지 계속 호출하고, 재귀가 반환되면서 +1
    private int getHeight(Node root) {
        if (root == null) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    /*****************************
     * Solution #2
     *****************************/
    private boolean isBalanced2(Node root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    private int checkHeight(Node root) {
        if (root == null) return -1;
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        }
        else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /*****************************
     * Solution #3
     *****************************/
    class Level {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    private boolean isBalanced3(Node root) {
        Level obj = new Level();
        checkBalanced(root, obj, 0);
        if (Math.abs(obj.min - obj.max) > 1) {
            return false;
        }
        else {
            return true;
        }
    }

    private void checkBalanced(Node node, Level obj, int level) {
        // 맨 마지막 노드를 만났을 때에 지금까지 level+N 길이를 업데이트
        if (node == null) {
            if (level < obj.min) {
                obj.min = level;
            }
            else if (level > obj.max) {
                obj.max = level;
            }
            return;
        }

        // 맨 마지막 노드가 아니니까 level+1 하면서 재귀호출
        checkBalanced(node.left, obj, level+1);
        checkBalanced(node.right, obj, level+1);
    }


    public static void main(String[] args) {
        BalanceCheck balanceCheck = new BalanceCheck(10);
        Node root = balanceCheck.tree.root;

        System.out.println(balanceCheck.isBalanced(root));
        System.out.println(balanceCheck.isBalanced2(root));
        System.out.println(balanceCheck.isBalanced3(root));
        System.out.println("-------------------");

        balanceCheck.makeUnBalanced(root);
        System.out.println(balanceCheck.isBalanced(root));
        System.out.println(balanceCheck.isBalanced2(root));
        System.out.println(balanceCheck.isBalanced3(root));
        System.out.println("-------------------");

        balanceCheck.makeDeepUnBalanced(root);
        System.out.println(balanceCheck.isBalanced(root));
        System.out.println(balanceCheck.isBalanced2(root));
        System.out.println(balanceCheck.isBalanced3(root));
    }

}
