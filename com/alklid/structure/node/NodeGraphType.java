package alklid.structure.node;

import java.util.LinkedList;

public class NodeGraphType {

    public int data;
    public LinkedList<NodeGraphType> adjacent; // 인접한 노드
    public boolean marked;

    public NodeGraphType(int data) {
        this.data = data;
        this.marked = false;
        this.adjacent = new LinkedList<>();
    }

}
