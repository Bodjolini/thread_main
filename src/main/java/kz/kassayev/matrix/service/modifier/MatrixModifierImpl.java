package kz.kassayev.matrix.service.modifier;

import kz.kassayev.matrix.entity.Matrix;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixModifierImpl implements MatrixModifier {
    private static Logger logger = LogManager.getLogger();

    public boolean modifyMatrix(int hundlerId, int[] index) {
        if (index != null) {
            Matrix.getInstance().setMatrixField(index[0], index[1], hundlerId);
            logger.info("Hundler: " + hundlerId + " matrix[" + index[0] + "][" + index[1] + "] was modified");
            return true;
        }
        logger.info("Hundler: " + hundlerId + " no fields to be modified");
        return false;
    }
}
