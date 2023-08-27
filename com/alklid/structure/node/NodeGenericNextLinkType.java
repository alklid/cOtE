package alklid.structure.node;

public class NodeGenericNextLinkType<T> {

    public T data;
    public NodeGenericNextLinkType<T> next;

    public NodeGenericNextLinkType(T data) {
        this.data = data;
    }

}
