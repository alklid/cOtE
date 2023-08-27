package alklid.algorithm.study.tree;

import alklid.structure.node.Node;

/**
 * Binary Tree
 *  - Node 에 Child Node 가 최대 2개까지만 붙는 트리
 * Binary Search Tree
 *  - Binary Tree 중에서,
 *  - 왼쪽 노드와 그 이하 노드는 자신보다 작아야 하고,
 *  - 오른쪽 노드와 그 이하 노드는 현재 노드보다 커야 함.
 *  - 그래서 현재 노드의 값을 보고, 작거나/큰 것을 찾을때 경로를 빨리 정할 수 있음.
 *            (8)
 *           ↙   ↘
 *         (6)   (10)
 *        ↙   ↘     ↘
 *      (4)   (7)    (11)
 * Complete Binary Tree (완전 이진트리)
 *   - 모든 노드들이 레벨별로 왼쪽부터 채워져 있는 경우
 * Full Binary Tree
 *   - 노드들의 Child 가 하나도 없거나 2개로만 구성된 트리
 * Perfect Binary Tree
 *   - 노드들의 Child 가 모두 2개로 구성된 트리
 *   - 레벨 n 일때 노드의 갯수가 2n-1 인 트리
 *
 *       (1)
 *      ↙   ↘
 *    (2)   (3)
 *   ↙   ↘
 * (4)   (5)
 *
 * Root 가 In/Pre/Post 에 위치하는 탐색
 * InOrder (Left, Root, Right) : 4 2 5 1 3
 * PreOrder (Root, Left, Right) : 1 2 4 5 3
 * PostOrder (Left, Right, Root) : 4 5 2 3 1
 */
public class BinaryTree {
    public Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node makeNode(Node left, int data, Node right) {
        Node node = new Node(data);
        node.left = left;
        node.right = right;
        return node;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        Node n4 = t.makeNode(null, 4, null);
        Node n5 = t.makeNode(null, 5, null);
        Node n2 = t.makeNode(n4, 2, n5);
        Node n3 = t.makeNode(null, 3, null);
        Node n1 = t.makeNode(n2, 1, n3);
        t.setRoot(n1);

        System.out.println("InOrder 4 2 5 1 3 ------");
        t.inOrder(t.getRoot());

        System.out.println("PreOrder 1 2 4 5 3 ------");
        t.preOrder(t.getRoot());

        System.out.println("PostOrder 4 5 2 3 1 ------");
        t.postOrder(t.getRoot());
    }
}
