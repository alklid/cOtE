package alklid.algorithm.study.tree;

import alklid.structure.Tree;
import alklid.structure.node.Node;

/**
 * 정렬이 되어 있고, 고유한 정수로만 이루어진 배열이 있다.
 * 이 배열로 이진검색 트리를 구현하시오.
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
public class ArrayToTree {

    public Tree tree;

    public ArrayToTree(int[] arr) {
        tree = new Tree(arr);
    }

    private void searchBinaryTree(Node n, int find) {
        if (find < n.data) {
            System.out.println("Data is smaller than " + n.data);
            searchBinaryTree(n.left, find);
        }
        else if (find > n.data) {
            System.out.println("Data is bigger than " + n.data);
            searchBinaryTree(n.right, find);
        }
        else {
            System.out.println("Found!!");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        ArrayToTree arrayTree = new ArrayToTree(arr);
        Node root = arrayTree.tree.root;

        arrayTree.searchBinaryTree(root, 9);
        System.out.println("--------------");
        arrayTree.searchBinaryTree(root, 6);
    }

}
