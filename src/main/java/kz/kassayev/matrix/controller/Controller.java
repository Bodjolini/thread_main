package kz.kassayev.matrix.controller;

import kz.kassayev.matrix.entity.Hundler;
import kz.kassayev.matrix.report.MatrixReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Controller {
    private static Logger logger = LogManager.getLogger();

    public void controllerForMain() {
        Thread firstThread = new Hundler();
        Thread secondThread = new Hundler();
        Thread thirdThread = new Hundler();
        Thread fourthThread = new Hundler();
        Thread fifthThread = new Hundler();
        Thread sixthThread = new Hundler();
        try {
            firstThread.start();
            secondThread.start();
            thirdThread.start();
            fourthThread.start();
            fifthThread.start();
            sixthThread.start();

            firstThread.join();
            secondThread.join();
            thirdThread.join();
            fourthThread.join();
            fifthThread.join();
            sixthThread.join();

        } catch (InterruptedException e) {
            logger.error(e);
            Thread.currentThread().interrupt();
        }
        MatrixReport report = new MatrixReport();
        report.printReport();
    }
}
