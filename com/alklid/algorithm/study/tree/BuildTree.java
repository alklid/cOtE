package alklid.algorithm.study.tree;

import alklid.structure.node.Node;

/**
 * 순회 결과로 원본트리 재현하기
 * 트리를 순회하는 방법
 * - inOrder : left -> root -> right
 * - preOrder : root -> left -> right
 * - postOrder : left -> right -> root
 *
 * 1. preOrder 만으로는 트리를 재현할 수 없음
 *
 * 2. preOrder + inOrder
 *    - PreOrder 의 첫번째는 무조건 root
 *    - root 를 가지고 InOrder 에서 찾으면, root 기준으로 왼쪽/오른쪽 노드들을 확인할 수 있음.
 *      - PreOrder 에서 첫 노드(root)의 다음 노드는 왼쪽 그룹의 root 노드
 *      - 왼쪽 그룹의 root 를 가지고 InOrder 에서 찾으면, 또 해당 root 기준으로 왼쪽/오른쪽 노드들을 확인할 수 있음.
 *    - 더 이상 노드가 없을 때까지 위 과정을 반복
 *
 * 3. postOrder + inOrder
 *    - PostOrder 의 마지막은 무조건 root
 *    - root 를 가지고 InOrder 에서 찾으면, root 기준으로 왼쪽/오른쪽 노드들을 확인할 수 있음.
 *      - PostOrder 에서 마지막 노드(root)의 바로 이전 노드는 오른쪽 그룹의 root 노드
 *      - 오른쪽 그룹의 root 를 가지고 InOrder 에서 찾으면, 또 해당 root 기준으로 왼쪽/오른쪽 노드들을 확인할 수 있음.
 *    - 더 이상 노드가 없을 때까지 위 과정을 반복
 *
 * 4. preOrder + postOrder
 *    - 모든 노드가 자식을 2개씩 가지고 있는 full binary tree 는 재현할 수 있지만, 그렇지 않다면 재현할 수 없음.
 */
public class BuildTree {
    public Node root;

    // preOrder, postOrder 배열을 어디까지 조회했는지 가리키는 포인터
    static int pIndex = 0;

    // preOrder + inOrder 방식으로 트리 재현
    private void buildTreeByInPre(int in[], int pre[]) {
        // preOrder 에서 어디까지 가져왔는지 저장할 변수
        // preOrder 에서 최 상위 root 는 맨 처음이니까 0으로 시작
        pIndex = 0;

        // 재귀함수를 호출할때 검사할 InOrder 조회 결과 배열의 처음부터 끝까지 설정
        root = buildTreeByInPre(in, pre, 0, in.length-1);
    }

    // start, end : inOrder 에서 처리할 배열의 영향을 명시한 시작과 끝 인덱스
    private Node buildTreeByInPre(int[] in, int[] pre, int start, int end) {
        // start 인덱스부터 수행하다가 end 인덱스를 넘어가면 종료
        if (start > end) return null;

        // preOrder 에서 맨 처음은 최상위 root 노드, 그 다음은 왼쪽 그룹의 root.. 이런식으로 증가처리
        Node node = new Node(pre[pIndex++]);

        // 서브 트리에 해당 노드 하나밖에 없는 경우, 더 이상 하위 조회할게 없음
        if (start == end) return node;

        // 해당 노드의 데이터로 inOrder 에서 배열의 위치를 찾음 -> root 기준으로 왼쪽/오른쪽을 찾기 위함
        int mid = search(in, start, end, node.data);

        // inOrder 에서 root 기준으로 왼쪽을 붙여나가는 재귀호출
        node.left = buildTreeByInPre(in, pre, start, mid - 1);

        // inOrder 에서 root 기준으로 오른쪽을 붙여나가는 재귀호출
        node.right = buildTreeByInPre(in, pre, mid + 1, end);

        return node;
    }

    // postOrder + inOrder 방식으로 트리 재현
    private void buildTreeByInPost(int in[], int post[]) {
        // postOrder 에서 어디까지 가져왔는지 저장할 변수
        // postOrder 에서 최 상위 root 는 맨 마지막이니까 post.length - 1 으로 시작
        pIndex = post.length - 1;

        // 재귀함수를 호출할때 검사할 InOrder 조회 결과 배열의 처음부터 끝까지 설정
        root = buildTreeByInPost(in, post, 0, in.length-1);
    }

    // start, end : inOrder 에서 처리할 배열의 영향을 명시한 시작과 끝 인덱스
    private Node buildTreeByInPost(int[] in, int[] post, int start, int end) {
        if (start > end) return null;

        // postOrder 에서 맨 마지막은 최상위 root 노드, 그 다음은 오른쪽 그룹의 root.. 이런식으로 감소처리
        Node node = new Node(post[pIndex--]);

        // 서브 트리에 해당 노드 하나밖에 없는 경우, 더 이상 하위 조회할게 없음
        if (start == end) return node;

        // 해당 노드의 데이터로 inOrder 에서 배열의 위치를 찾음 -> root 기준으로 왼쪽/오른쪽을 찾기 위함
        int mid = search(in, start, end, node.data);

        // inOrder 에서 root 기준으로 오른쪽을 붙여나가는 재귀호출
        // right 먼저 하는 이유 : postOrder(root -> left -> right) 이니까
        // 재현을 할 때에는 반대로 (right -> left -> root) 식으로 노드를 붙여줘야 함
        node.right = buildTreeByInPost(in, post, mid + 1, end);

        // inOrder 에서 root 기준으로 왼쪽을 붙여나가는 재귀호출
        node.left = buildTreeByInPost(in, post, start, mid - 1);

        return node;
    }

    // inOrder 에서 value 값을 가지는 배열의 인덱스를 반환하는 함수
    private int search(int[] arr, int start, int end, int value) {
        int i;
        for (i = start; i < end; i++) {
            if (arr[i] == value) return i;
        }

        return i;
    }

    // 결과를 증명하기 위해 재현된 트리를 inOrder 방식으로 출력하는 함수
    private void printInOrder(Node node) {
        if (node == null) return;

        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }


    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        int[] pre = {4,2,1,3,6,5,7};
        int[] in = {1,2,3,4,5,6,7};
        int[] post = {1,3,2,5,7,6,4};

        tree.buildTreeByInPre(in, pre);
        tree.printInOrder(tree.root);

        System.out.println();

        tree.buildTreeByInPost(in, post);
        tree.printInOrder(tree.root);
    }
}
