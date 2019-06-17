package kz.kassayev.matrix.exception;

public class OutOfIndexLimitException extends Exception {
    public OutOfIndexLimitException() {
    }

    public OutOfIndexLimitException(String s) {
        super(s);
    }

    public OutOfIndexLimitException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public OutOfIndexLimitException(Throwable throwable) {
        super(throwable);
    }
}
