package alklid.structure;

import alklid.structure.node.Node;

import java.util.HashMap;

public class Tree {

    public Node root;
    public int size;

    // 단순하게 Node 를 편하게 가져오려고 만든 Map
    HashMap<Integer, Node> rootMap = new HashMap<>();

    public Tree() {
    }

    // 크기를 받아서 Tree 로 만드는 함수
    public Tree(int size) {
        this.size = size;
        root = buildTree(0, size - 1);
    }

    public Tree(int size, Node parent) {
        this.size = size;
        root = buildTree(0, size - 1, parent);
    }

    public Node buildTree(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;

        // 중간값의 지점을 노드로 지정하고
        Node node = new Node(mid);

        // 중간값 까지를 노드의 왼쪽노드로 지정
        node.left = buildTree(start, mid - 1);

        // 중간값에서 마지막까지를 노드의 오른쪽노드로 지정
        node.right = buildTree(mid + 1, end);

        return node;
    }

    public Node buildTree(int start, int end, Node parent) {
        if (start > end) return null;
        int mid = (start + end) / 2;

        // 중간값의 지점을 노드로 지정하고
        Node node = new Node(mid);

        // 중간값 까지를 노드의 왼쪽노드로 지정
        node.left = buildTree(start, mid - 1, node);

        // 중간값에서 마지막까지를 노드의 오른쪽노드로 지정
        node.right = buildTree(mid + 1, end, node);

        // 부모노드 설정
        node.parent = parent;
        rootMap.put(mid, node);

        return node;
    }

    // 배열을 받아서 Tree 로 만드는 함수
    public Tree(int[] a) {
        root = buildTree(a, 0, a.length-1);
    }

    public void buildTree(int[] a) {
        root = buildTree(a, 0, a.length - 1);
    }

    public Node buildTree(int[] a, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;

        // 중간값의 지점을 노드로 지정하고
        Node node = new Node(a[mid]);

        // 중간값 까지를 노드의 왼쪽노드로 지정
        node.left = buildTree(a, start, mid-1);

        // 중간값에서 마지막까지를 노드의 오른쪽노드로 지정
        node.right = buildTree(a, mid+1, end);

        return node;
    }

    public Node getNode(int data) {
        return rootMap.get(data);
    }

}
