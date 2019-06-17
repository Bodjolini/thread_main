package kz.kassayev.matrix.entity;

import kz.kassayev.matrix.service.finder.IndexFinder;
import kz.kassayev.matrix.service.finder.IndexFinderImpl;
import kz.kassayev.matrix.service.modifier.MatrixModifier;
import kz.kassayev.matrix.service.modifier.MatrixModifierImpl;
import kz.kassayev.matrix.generator.IdGenerator;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Level;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Hundler extends Thread {
    private static final int MODIFIED_FIELDS_COUNT = 3;
    private static final int WORKERS_COUNT = 6;
    private static Logger logger = LogManager.getLogger();
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(WORKERS_COUNT);
    private int hundlerId;

    public Hundler() {
        this.hundlerId = IdGenerator.generateHundlerId();
    }

    @Override
    public void run() {
        logger.log(Level.INFO, " " + this.hundlerId + " started");
        int counter = 0;
        try {
            cyclicBarrier.await(1, TimeUnit.SECONDS);
            MatrixModifier matrixModifier = new MatrixModifierImpl();
            IndexFinder indexFinder = new IndexFinderImpl();
            while (matrixModifier.modifyMatrix(this.hundlerId, indexFinder.findNextIndex())) {
                counter++;
                if (counter <= MODIFIED_FIELDS_COUNT) {
                    cyclicBarrier.await(2, TimeUnit.SECONDS);
                }
            }
        } catch (InterruptedException e) {
            logger.error(e);
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            logger.error(e);
        } catch (TimeoutException e) {
            logger.error(e);
        }
    }
}
