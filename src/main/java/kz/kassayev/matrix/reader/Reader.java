package kz.kassayev.matrix.reader;

import kz.kassayev.matrix.entity.Margin;
import kz.kassayev.matrix.exception.OutOfIndexLimitException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private String fileName;
    private int size;

    public Reader(int size, String dataFileName) {
        this.fileName = dataFileName;
        this.size = size;
    }

    public Margin[][] readMatrix() throws IOException, OutOfIndexLimitException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(fileName));

        Margin[][] matrix;
        matrix = new Margin[size][size];

        try {
            String tmp;
            int i = 0;
            int j = 0;
            int k;
            while ((tmp = br.readLine()) != null) {
                if (i >= size) {
                    throw new OutOfIndexLimitException("Preset size: " + size + "x" + size);
                }
                String[] s = tmp.split(",");
                j = 0;
                for (String res : s) {
                    if (j >= size) {
                        throw new OutOfIndexLimitException("Preset size: " + size + "x" + size);
                    }
                    k = Integer.parseInt(res);
                    matrix[i][j] = new Margin(k, i, j);
                    j++;
                }
                i++;
            }
            if ((i < size) || (j < size)) {
                throw new OutOfIndexLimitException("Preset size: " + size + "x" + size);
            }
            return matrix;
        } finally {
            br.close();
        }
    }
}
