package alklid.algorithm.study.graph;

import alklid.structure.QueueGenericNode;
import alklid.structure.node.NodeGraphType;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 아래와 같은 graph 정보에서 경로 탐색
 *-------------------------------
 *    0
 *   /
 *  1 -- 3    7
 *  |  / | \ /
 *  | /  |  5
 *  2 -- 4   \
 *            6 - 8
 * -------------------------------
 */
public class Graph {
    public NodeGraphType[] nodes;

    public Graph(int size) {
        nodes = new NodeGraphType[size];
        for (int i = 0; i < size; i++) { // 편의상 인덱스 번호로 노드번호 설정
            nodes[i] = new NodeGraphType(i);
        }
    }

    // 두 노드의 관계를 저장
    void addEdge(int i1, int i2) {
        NodeGraphType n1 = nodes[i1];
        NodeGraphType n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    // 두 노드의 관계를 제거
    void removeEdge(int i1, int i2) {
        NodeGraphType n1 = nodes[i1];
        NodeGraphType n2 = nodes[i2];
        if (n1.adjacent.contains(n2)) {
            n1.adjacent.remove(n2);
        }
        if (n2.adjacent.contains(n1)) {
            n2.adjacent.remove(n1);
        }
    }

    private void visit(NodeGraphType n) {
        System.out.print(n.data + " ");
    }

    void initMarks() {
        for (NodeGraphType n : nodes) {
            n.marked = false;
        }
    }
    // -------- 여기까지 기본 함수


    /****************************************
     * DFS (Depth First Search, 깊이 우선 탐색)
     ****************************************/
    // DFS 노드번호 없이 호출하면 0번부터 시작
    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        NodeGraphType root = nodes[index];
        Stack<NodeGraphType> stack = new Stack<>();

        root.marked = true;
        stack.push(root); // 시작 노드를 마킹하고 Stack 넣음.

        // Stack 에 노드가 없을때 까지 반복
        while (!stack.isEmpty()) {
            NodeGraphType n = stack.pop();
            for (NodeGraphType c : n.adjacent) {
                if (!c.marked) {
                    c.marked = true;
                    stack.push(c);
                }
            }
            visit(n);
        }
    }


    /*****************************
     * DFS 재귀호출
     *****************************/
    void dfsRecursive() {
        dfsRecursive(0);
    }

    void dfsRecursive(int index) {
        NodeGraphType r = nodes[index];
        dfsRecursive(r);
    }

    // 재귀호출을 이용한 DFS
    void dfsRecursive(NodeGraphType r) {
        if (r == null) return;

        r.marked = true; // 마킹하고
        visit(r);
        for (NodeGraphType c : r.adjacent) { // 인접 노드를 재귀호출
            if (!c.marked) {
                dfsRecursive(c);
            }
        }
    }


    /******************************************
     * BFS (Breadth First Search, 너비 우선 탐색)
     ******************************************/
    // BFS 노드번호 없이 호출하면 0번부터 시작
    void bfs() {
        bfs(0);
    }

    void bfs(int index) {
        NodeGraphType root = nodes[index];
        QueueGenericNode<NodeGraphType> queue = new QueueGenericNode<>();

        root.marked = true;
        queue.add(root); // 시작 노드를 마킹하고 Queue 넣음.

        // Queue 에 노드가 없을때 까지 반복
        while (!queue.isEmpty()) {
            NodeGraphType n = queue.remove();
            for (NodeGraphType c : n.adjacent) {
                if (!c.marked) {
                    c.marked = true;
                    queue.add(c);
                }
            }
            visit(n);
        }
    }


    /*****************************
     * 두 노드 간의 경로 확인
     *****************************/
    boolean search(int i1, int i2) {
        return search(nodes[i1], nodes[i2]);
    }

    // BFS 방식으로 처리
    boolean search(NodeGraphType start, NodeGraphType end) {
        initMarks();
        LinkedList<NodeGraphType> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            NodeGraphType n = q.removeFirst();
            if (n == end) {
                return true;
            }

            for (NodeGraphType c : n.adjacent) {
                if (!c.marked) {
                    c.marked = true;
                    q.add(c);
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        graph.initMarks();
        graph.bfs();
        System.out.println();

        graph.initMarks();
        graph.dfsRecursive(3);
        System.out.println();

        System.out.println("Search 1 to 8 : " + graph.search(1, 8)); // true
        System.out.println("Search 7 to 8 : " + graph.search(7, 8)); // true

        graph.removeEdge(3, 5); // 연결끊으면
        System.out.println("Search 1 to 8 : " + graph.search(1, 8)); // false
        System.out.println("Search 7 to 8 : " + graph.search(7, 8)); // true
    }

}
