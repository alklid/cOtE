package alklid.structure;

public class ArrayList {
    private Object[] data;
    private int size;
    private int index;

    public ArrayList() {
        this.size = 1;
        this.data = new Object[this.size];
        this.index = 0;
    }

    public void add(Object obj) {
        if (this.index == this.size-1) {
            doubling();
        }
        this.data[this.index] = obj;
        this.index++;
    }

    private void doubling() {
        this.size = this.size * 2;
        Object[] newObj = new Object[this.size];
        for (int i=0; i<this.data.length; i++) {
            newObj[i] = this.data[i];
        }
        this.data = newObj;
    }

    public Object get(int i) {
        if (i > this.index-1 || i < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.data[i];
    }

    public void remove(int i) {
        if (i > this.index-1 || i < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int x = i; x<this.data.length-1; x++) {
            data[x] = data[x+1];
        }
        this.index--;
    }
}
