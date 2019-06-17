package kz.kassayev.matrix.entity;

import kz.kassayev.matrix.exception.OutOfIndexLimitException;
import kz.kassayev.matrix.reader.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Matrix {
    private static Logger logger = LogManager.getLogger();
    private static final int N = 8;
    private static Matrix instance;
    private static Lock lock = new ReentrantLock(true);
    private static AtomicBoolean created = new AtomicBoolean(false);

    private Margin[][] numbers;

    private Matrix() {
        Reader reader = new Reader(N, "file.txt");
        try {
            numbers = reader.readMatrix();
        } catch (OutOfIndexLimitException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public static Matrix getInstance() {
        if (!created.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new Matrix();
                    created.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public int getValue(int i, int j) {
        return numbers[i][j].getValueMargin();
    }

    public int getSize() {
        if (numbers != null) {
            return numbers.length;
        } else {
            return 0;
        }
    }

    public void setMatrixField(int i, int j, int workerId) {
        numbers[i][j].setValueMargin(workerId);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\n");
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                s.append(numbers[i][j]);
                s.append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
