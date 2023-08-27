package alklid.structure.node;

public class NodeKeyValueType {
    public String key;
    public String value;

    public NodeKeyValueType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String value() {
        return value;
    }

    public void value(String value) {
        this.value = value;
    }
}
