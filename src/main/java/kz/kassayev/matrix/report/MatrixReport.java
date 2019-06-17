package kz.kassayev.matrix.report;

import kz.kassayev.matrix.entity.Matrix;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixReport {
    private static Logger logger = LogManager.getLogger();

    public void printReport() {
        logger.info("print matrix");
        System.out.println(Matrix.getInstance().toString());
    }
}
