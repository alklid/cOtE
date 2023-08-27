package alklid.structure.node;

public class NodeNextLinkType {
    public int val;
    public NodeNextLinkType next;

    public NodeNextLinkType() {}

    public NodeNextLinkType(int val) {
        this.val = val;
    }

    public NodeNextLinkType addNext(int i) {
        NodeNextLinkType next = new NodeNextLinkType(i);
        this.next = next;
        return next;
    }

    public NodeNextLinkType addNext(NodeNextLinkType next) {
        this.next = next;
        return next;
    }
}
