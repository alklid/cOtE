package alklid.algorithm.study.tree;

import alklid.structure.Tree;
import alklid.structure.node.Node;

// #Solution 5 에서 메모라이즈용으로 사용되는 데이터 구조체
class Result {
    Node node;
    boolean isAncestor;

    Result(Node node, boolean isAncestor) {
        this.node = node;
        this.isAncestor = isAncestor;
    }
}

/**
 * 이진트리에서 주어진 두개의 노드의 첫번째 공통된 부모를 찾으시오.
 * 단, 다른 자료구조는 사용하지 않음
 *
 * Solution #1
 * 각 노드에서 루트까지의 길이를 구하고, 두 노드의 길이를 짧은 노드에 맞추고
 * 한칸씩 올라가면서 같은 노드이면 공통 부모임.
 * 노드의 트리의 깊이 만큼만 가면 되니까 시간복잡도는 O(d)
 *
 * Solution #2
 * 부모에게 나말고 다른쪽 서브트리에 다른노드가 있는지 확인
 * 만약 있다면 해당 부모가 공통부모임. 없으면 하나 더 올라가서 확인 반복.
 * 반대쪽 서브트리의 노드만큼만 찾으면 되니까 시간복잡도는 O(t) -> 최악의 경우 O(N)
 *
 * Solution #3
 * 부모 노드가 없을 경우, 루트에서부터 내려오면서 확인
 * 왼쪽/오른쪽에 하나씩 있으면 공통부모.
 * 한쪽에 2개 모두 있으면 한쪽으로 가서 다시 왼쪽/오른쪽으로 검색
 * 시간복잡도는 O(log n)² -> O(N) 보다 작으니 O(N) 으로 표기
 *
 * Solution #4
 * Solution #3 이 로직은 알기 쉽지만, 루트를 내려오면서 이미 방문한 노드를 재방문하는 비효율이 있음.
 * PostOrder(left -> right -> root) 방식으로 한번의 노드만 방문해서 찾도록 함.
 *
 * Solution #5
 * Solution #4 의 단점으로, 노드가 트리안에 아예 존재하지 않는 경우, 찾은 노드중에 하나를 반환해버림.
 * 한쪽이 Null 이니까 계속 한쪽에서 찾은 노드만 루트까지 올려버리니까, 찾은 노드중에 하나를 반환해버림.
 * 따라서 올라온 노드가, 찾은 노드인지 공통부모인지를 명확하게 설정해서 참조하도록 함.
 *
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
public class TreeSearchAncestor {
    public Tree tree;

    /*****************************
     * Solution #1
     *****************************/
    private Node commonAncestor(int d1, int d2) {
        Node p = tree.getNode(d1);
        Node q = tree.getNode(d2);

        int diff = depth(p) - depth(q);
        Node first = diff > 0 ? q : p;
        Node second = diff > 0 ? p : q;

        // 긴쪽을 같은 레벨로 맞춰줌.
        second = goUpBy(second, Math.abs(diff));

        // 둘이 같거나 null 일때까지 하나씩 올라감
        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }

        // null 이 아니면 같은 공통부모니까 둘중에 아무거나 반환
        return first == null || second == null ? null : first;
    }

    // Node 를 길이만큼 올라감
    private Node goUpBy(Node node, int diff) {
        while (diff > 0 && node != null) {
            node = node.parent;
            diff--;
        }
        return node;
    }

    // Node 에서 root 까지의 길이
    private int depth(Node node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }

        return depth;
    }


    /*****************************
     * Solution #2
     *****************************/
    private Node commonAncestor2(int d1, int d2) {
        Node p = tree.getNode(d1);
        Node q = tree.getNode(d2);

        // p 가 q 의 부모노드이면 p 반환
        if (covers(p, q)) {
            return p;
        }

        // q 가 p 의 부모노드이면 q 반환
        if (covers(q, p)) {
            return q;
        }

        // 다른쪽 자식노드를 가져옴
        Node sibling = getSibling(p);
        Node parent = p.parent;
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    private Node getSibling(Node node) {
        if (node == null || node.parent == null) {
            return null;
        }

        return node.parent.left == node ? node.parent.right : node.parent.left;
    }

    private boolean covers(Node n, Node q) {
        if (n == null) return false;

        if (n == q) {
            return true;
        }
        return covers(n.right, q) || covers(n.left, q);
    }


    /*****************************
     * Solution #3
     *****************************/
    private Node commonAncestor3(int d1, int d2) {
        Node p = tree.getNode(d1);
        Node q = tree.getNode(d2);

        // 찾는 노드가 존재하지 않으면 null
        if (!covers(tree.root, p) || !covers(tree.root, q)) {
            return null;
        }
        return ancestorHelper(tree.root, p, q);
    }

    private Node ancestorHelper(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) return root;

        boolean pInLeft = covers(root.left, p);
        boolean qInLeft = covers(root.left, q);

        // 양쪽에 있지 않고 한쪽씩 있다면 지금이 공통부모
        if (pInLeft != qInLeft) {
            return root;
        }

        // 둘다 왼쪽에 있었으면 왼쪽 내려가서 다시 검사, 아니면 오른쪽으로 내려가서 다시 검사
        Node nextNode = (pInLeft && qInLeft) ? root.left : root.right;

        return ancestorHelper(nextNode, p, q);
    }


    /*****************************
     * Solution #4
     *****************************/
    private Node commonAncestor4(int d1, int d2) {
        Node p = tree.getNode(d1);
        Node q = tree.getNode(d2);

        // 왼쪽, 오른쪽 한번씩 다녀와
        //  모두 다녀와도 Null 이면, 자신이 둘중에 하나인지 비교
        //      맞으면 자신을 반환, 아니면 Null 반환
        //  어느 한쪽이 null 이 아니면, null 이 아닌게 찾으려는 두 노드인지 확인
        //      둘다 아니면 그놈이 공통부모 --> 종료
        //      둘중에 한쪽이면, 자신이 둘중에 하나인지 비교
        //          맞으면 자신을 반환, 아니면 null 이 아닌쪽을 반환
        //  양쪽이 null 이 아니면, 자신이 공통부모, 자신을 반환
        return findAncestorByPostOrder(tree.root, p, q);
    }

    private Node findAncestorByPostOrder(Node root, Node p, Node q) {
        if (root == null) return null;
        if (root == p && root == q) return root;

        Node x = findAncestorByPostOrder(root.left, p, q);
        // 왼쪽에서 올라온 노드가 null 이 아니고, 찾으려는 두 노드도 아니면 공통부모가 올라온거니까 해당 노드를 반환
        if (x != null && x != p && x != q) {
            return x;
        }

        Node y = findAncestorByPostOrder(root.right, p, q);
        // 왼쪽에서 올라온 노드가 null 이 아니고, 찾으려는 두 노드도 아니면 공통부모가 올라온거니까 해당 노드를 반환
        if (y != null && x != p && x != q) {
            return y;
        }

        // 양쪽이 null 이 아니면, 자신이 공통부모, 자신을 반환
        if (x != null && y != null) {
            return root;
        }

        // 자신이 찾으려는 노드중에 하나면, 자신을 반환
        else if (root == p || root == q) {
            return root;
        }

        // 둘중에 null 이 아닌쪽을 반환
        else {
            return x == null ? y : x;
        }
    }

    /*****************************
     * Solution #5
     *****************************/
    private Node commonAncestor5(int d1, int d2) {
        Node p = tree.getNode(d1);
        Node q = tree.getNode(d2);

        Result r = findAncestorByPostOrderResult(tree.root, p, q);
        if (r.isAncestor) {
            return r.node;
        }

        return null;
    }

    private Result findAncestorByPostOrderResult(Node root, Node p, Node q) {
        if (root == null) return new Result(null, false);
        if (root == p && root == q) return new Result(root, true);

        Result rx = findAncestorByPostOrderResult(root.left, p, q);
        // 왼쪽에서 올라온 노드가 null 이 아니고, 찾으려는 두 노드도 아니면 공통부모가 올라온거니까 해당 노드를 반환
        if (rx.isAncestor) {
            return rx;
        }

        Result ry = findAncestorByPostOrderResult(root.right, p, q);
        // 왼쪽에서 올라온 노드가 null 이 아니고, 찾으려는 두 노드도 아니면 공통부모가 올라온거니까 해당 노드를 반환
        if (ry.isAncestor) {
            return ry;
        }

        // 양쪽이 null 이 아니면, 자신이 공통부모, 자신을 반환
        if (rx.node != null && ry.node != null) {
            return new Result(root, true);
        }

        // 자신이 찾으려는 노드중에 하나면, 자신을 반환
        else if (root == p || root == q) {
            // Solution #5 키포인프
            // 만약 이미 참조결과에 공통부모가 들어가 있으면, 찾는 노드인 동시에 공통부모임.
            // 결과에 노드가 이미 들어가 있는 여부에 따 찾은 노드가 공통부모일수도 있음.
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        }

        // 둘중에 null 이 아닌쪽을 반환
        else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }

    public static void main(String[] args) {
        TreeSearchAncestor searchAncestor = new TreeSearchAncestor();
        searchAncestor.tree = new Tree(10, null);
        Node fa = searchAncestor.commonAncestor(3, 8);
        Node fa2 = searchAncestor.commonAncestor2(3, 8);
        Node fa3 = searchAncestor.commonAncestor3(3, 8);
        Node fa4 = searchAncestor.commonAncestor4(3, 8);
        Node fa5 = searchAncestor.commonAncestor5(3, 8);
        System.out.println("The first common ancestor is " + fa.data);
        System.out.println("The first common ancestor is " + fa2.data);
        System.out.println("The first common ancestor is " + fa3.data);
        System.out.println("The first common ancestor is " + fa4.data);
        System.out.println("The first common ancestor is " + fa5.data);
    }
}
