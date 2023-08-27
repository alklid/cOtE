package alklid.structure;

public class StringBuilder {
    private char[] value;
    private int size;
    private int index;

    public StringBuilder() {
        this.size = 1;
        this.value = new char[this.size];
        this.index = 0;
    }

    public void append(String str) {
        if (str == null) str = "null";

        int len = str.length();
        ensureCapacity(len);

        for (char c : str.toCharArray()) {
            this.value[this.index] = c;
            this.index++;
        }
    }

    public String toString() {
        return new String(value, 0, this.index);
    }

    // append 될때 배열의 크기가 부족하면 크기를 2배만큼 미리 늘려준다.
    private void ensureCapacity(int len) {
        if (this.index + len > this.size) {
            this.size = (this.size + len) * 2;
            char[] newValue = new char[this.size];
            for (int i=0; i<this.value.length; i++) {
                newValue[i] = this.value[i];
            }
            this.value = newValue;
        }
    }
}
