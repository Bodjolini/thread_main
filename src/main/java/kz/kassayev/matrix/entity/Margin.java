package kz.kassayev.matrix.entity;

public class Margin {
    private int i;
    private int j;
    private int modifiedBy = 0;
    private boolean modified = false;
    private int valueMargin;

    public Margin(int valueMargin, int i, int j) {
        this.valueMargin = valueMargin;
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    void setValueMargin(int hundlerId) {
        this.valueMargin = hundlerId;
        this.modified = true;
        this.modifiedBy = hundlerId;
    }

    int getValueMargin() {
        return valueMargin;
    }

    public boolean isModified() {
        return modified;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (isModified()) {
            s.append(modifiedBy);
        } else {
            s.append('(');
            s.append(valueMargin);
            s.append(')');
        }
        return s.toString();
    }
}
