package alklid.algorithm.study.tree;

import alklid.structure.Tree;
import alklid.structure.node.Node;

/**
 * T1 이 T2 보다 큰 두개의 트리가 있는데, T2 가 T1 의 서브트리인지 확인하는 함수를 구현
 *
 * InOrder, PreOrder, PostOrder 중에서 T1을 순회중에 T2 의 루트노드와 같은 노드를 만났을때
 * 모든 노드를 같은 방법으로 순회가 가능한 탐색법인 PreOrder(root->left->right) 를 통해 확인
 */
public class SubTreeContainsCheck {
    // 두 개의 트리를 받아서 t2 가 t1 에 포함 되는지 확인
    private boolean containsTree(Node t1, Node t2) {
        if (t2 == null) return false;
        return subTree(t1, t2);
    }

    // t1 을 PreOrder 순회 하면서 t2 의 root 노드와 같을 때까지 탐색
    private boolean subTree(Node t1, Node t2) {
        // t1 이 null 을 만날 때까지 t2 와 같은 노드를 못찾은 경우 false
        if (t1 == null) {
            return false;
        }
        else if (t1.data == t2.data && matchTree(t1, t2)) {
            return true;
        }

        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    // 두 개의 트리를 똑같이 순회 하면서 모든 노드의 값이 일치 하는지 확인
    private boolean matchTree(Node t1, Node t2) {
        // 두 개의 트리가 모드 노드가 값이 같아서 끝까지 도달 했으면 true
        if (t1 == null && t2 == null) {
            return true;
        }
        // 두 개 중에 하나라도 null 이면 먼저 끝에 도달 했으니 false
        else if (t1 == null || t2 == null) {
            return false;
        }
        else if (t1.data != t2.data) {
            return false;
        }
        else {
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        }
    }

    public static void main(String[] args) {
        Tree t1 = new Tree();
        Tree t2 = new Tree();

        boolean result;
        t1.root = t1.buildTree(0,9);
        t2.root = t2.buildTree(5,9);

        SubTreeContainsCheck containsCheck = new SubTreeContainsCheck();
        result = containsCheck.containsTree(t1.root, t2.root);
        System.out.println(result);

        t2.root = t2.buildTree(7,9);
        result = containsCheck.containsTree(t1.root, t2.root);
        System.out.println(result);
    }
}
