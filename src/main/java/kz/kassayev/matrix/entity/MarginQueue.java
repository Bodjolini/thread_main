package kz.kassayev.matrix.entity;

import java.util.ArrayList;
import java.util.List;

public class MarginQueue {
    private List<Margin> matrixMarginList = new ArrayList<Margin>();

    public MarginQueue() {
        Matrix matrix = Matrix.getInstance();
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                matrixMarginList.add(new Margin(matrix.getValue(i, j), i, j));
            }
        }
    }

    public Margin popNextField() {
        Margin margin = null;
        if (!matrixMarginList.isEmpty()) {
            margin = matrixMarginList.get(0);
            matrixMarginList = matrixMarginList.subList(1, matrixMarginList.size());
        }
        return margin;
    }
}
