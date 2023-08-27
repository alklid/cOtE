package alklid.algorithm.study.tree;

import alklid.structure.Tree;
import alklid.structure.node.Node;

/**
 * 주어진 트리가 이진검색트리인지를 확인하는 함수를 구현.
 * 이진검색트리는 왼쪽은 자신보다 작고, 오른쪽은 큰 값을 가짐
 *
 * Solution #1 : 시간 O(N), 공간 O(N) - 배열을 만드니까
 * InOrder 에서 순회하는 순서와 같음
 * 배열에 넣고 배열의 앞 뒤가 크기를 비교
 *
 * Solution #2 : 시간 O(N), 공간 O(1)
 * 배열을 쓰지말고, 이전 노드의 값을 바로 비교하자
 *
 * Solution #3 : 시간 O(N), 공간 O(1)
 * 내려가면서 조건을 추가.
 * 왼쪽으로 갈때에는 자신보다 작아야 하고 -> 자신이 MAX
 * 오른쪽으로 갈때에는 자신보다 커야 함 -> 자신이 MIN
 */
public class BinaryTreeCheck {
    public Tree tree;


    /*****************************
     * Solution #1
     *****************************/
    private boolean isValidateBST1() {
        int[] array = new int[tree.size];

        // InOrder 순회하면서 배열에 추가
        inOrder(tree.root, array);

        // 배열에서 정렬 순서 확인
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]) {
                return false;
            }
        }
        return true;
    }

    private int index = 0;
    private void inOrder(Node root, int[] array) {
        if (root == null) return;

        inOrder(root.left, array);
        array[index] = root.data;
        index++;
        inOrder(root.right, array);
    }


    /*****************************
     * Solution #2
     *****************************/
    private Integer last_printed = null;
    private boolean isValidateBST2() {
        return isValidateBST2(tree.root);
    }

    private boolean isValidateBST2(Node n) {
        if (n == null) return true;

        // 왼쪽 노드 순회
        if (!isValidateBST2(n.left)) return false;

        if (last_printed != null && n.data < last_printed) {
            return false;
        }
        last_printed = n.data;

        // 오른쪽 노드 순회
        if (!isValidateBST2(n.right)) return false;

        return true;
    }


    /*****************************
     * Solution #3
     *****************************/
    private boolean isValidateBST3() {
        return isValidateBST3(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidateBST3(Node n, int min, int max) {
        if (n == null) return true;

        if (n.data < min || n.data > max) {
            return false;
        }

        // 왼쪽으로 갈때에는 자신이 MAX
        // 오른쪽으로 갈때에는 자신이 MIN
        if (!isValidateBST3(n.left, min, n.data) ||
                !isValidateBST3(n.right, n.data, max)) {
            return false;
        }

        return true;
    }

    private void makeInValid() {
        tree.root.right.right.right.left = new Node(10);
        tree.size++;
        this.index = 0;
    }


    public static void main(String[] args) {
        BinaryTreeCheck treeCheck = new BinaryTreeCheck();
        treeCheck.tree = new Tree(10);

        System.out.println(treeCheck.isValidateBST1());
        System.out.println(treeCheck.isValidateBST2());
        System.out.println(treeCheck.isValidateBST3());

        treeCheck.makeInValid();
        System.out.println(treeCheck.isValidateBST1());
        System.out.println(treeCheck.isValidateBST2());
        System.out.println(treeCheck.isValidateBST3());
    }
}
