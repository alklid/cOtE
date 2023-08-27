package alklid.algorithm.study.tree;

import alklid.structure.node.Node;

/**
 * BST(Binary Search Tree)
 * BST Insertion
 * O(logN) 시간이 걸림
 *
 * BST Deletion
 *  1. no child
 *     - 부모 노드의 연결을 제거함
 *  2. one child
 *     - 부모 노드의 자식을 자신의 자식노드로 연결함
 *  3. 2 children
 *     - 왼쪽 노드 트리의 MAX(오른쪽 자식을 타고 가다가 끝까지 가면 가장 큰 값)
 *     - 오른쪽 노드 트리의 MIN(왼쪽 자식을 타고 가다가 끝까지 가면 가장 작은값)
 */
/*
       (4)
      /   \
     /     \
    /       \
  (2)       (6)
 /   \     /   \
(1)  (3)  (5)  (7)
 */
public class BinaryTreeInsertDelete {
    public Node root;

    // 해당 값을 갖는 노드를 찾는 함수
    Node search(Node root, int key) {
        if (root == null || root.data == key) return root;

        // 찾는 값이 현재 노드보다 작으면 왼쪽 자식 트리를 검색
        if (root.data > key) {
            return search(root.left, key);
        }

        // 찾는 값이 현재 노드보다 크면 오른쪽 자식 트리를 검색
        else {
            return search(root.right, key);
        }
    }

    // 노드를 추가하는 함수
    void insert(int data) {
        // 추가하다가 root 가 변경될 경우, root 를 재정의
        root = insert(root, data);
    }

    Node insert(Node node, int data) {
        // 맨 처음 root 가 null 일 경우나, 맨 마지막까지 도달했을 때
        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (data < node.data) {
            // 왼쪽 트리로 재귀호출해서 추가한 노드를 부모의 왼쪽에 붙임
            node.left = insert(node.left, data);
        }

        else {
            // 오른쪽 트리로 재귀호출해서 추가한 노드를 부모의 오른쪽에 붙임
            node.right = insert(node.right, data);
        }

        // 추가한 이후의 정리된 노드를 반환
        return node;
    }

    void delete(int data) {
        root = delete(root, data);
    }

    Node delete(Node node, int data) {
        if (node == null) return node;

        if (data < node.data) {
            // 왼쪽 트리로 재귀호출해서 삭제한 결과를 부모의 왼쪽에 붙임
            node.left = delete(node.left, data);
        }
        else if (data > node.data) {
            // 오른쪽 트리로 재귀호출해서 삭제한 결과를 부모의 오른쪽에 붙임
            node.right = delete(node.right, data);
        }
        else {
            // 삭제할 노드를 찾음
            // 1. 자식이 없는 경우
            if (node.left == null && node.right == null) {
                return null;
            }

            // 2. 자식이 한쪽(오른쪽)에만 있는 경우
            else if (node.left == null) {
                return node.right;
            }

            // 2. 자식이 한쪽(왼쪽)에만 있는 경우
            else if (node.right == null) {
                return node.left;
            }

            // 3. 자식이 둘다 있는 경우
            // 오른쪽 트리에서 가장 작은 값을 찾고
            node.data = findMin(node.right);

            // 오른쪽 트리에서 가장 작은 값을 가졌던 노드를 삭제
            node.right = delete(node.right, node.data);
        }

        // 삭제한 이후의 정리된 노드를 반환
        return node;
    }

    // 주어진 노드의 왼쪽트리를 돌면서 가장 작은 값을 반환
    int findMin(Node node) {
        int min = node.data;
        while (node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }

    // 테스트를 위해 InOrder 방식으로 순회하면서 출력하는 함수
    void inOrder() {
        inOrder(root);
        System.out.println();
    }

    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeInsertDelete tree = new BinaryTreeInsertDelete();
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.inOrder();
        tree.delete(5);
        tree.delete(6);
        tree.delete(2);
        tree.inOrder();
    }
}
