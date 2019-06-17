package kz.kassayev.matrix.service.finder;

import kz.kassayev.matrix.entity.Margin;
import kz.kassayev.matrix.entity.MarginQueue;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IndexFinderImpl implements IndexFinder {
    private static MarginQueue marginQueue = new MarginQueue();
    private static Lock lock = new ReentrantLock(true);

    public int[] findNextIndex() {
        lock.lock();
        try {
            int[] index = null;
            Margin margin = marginQueue.popNextField();
            if (margin != null) {
                index = new int[2];
                index[0] = margin.getI();
                index[1] = margin.getJ();
            }
            return index;
        } finally {
            lock.unlock();
        }
    }
}
