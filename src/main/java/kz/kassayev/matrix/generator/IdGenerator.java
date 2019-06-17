package kz.kassayev.matrix.generator;

public class IdGenerator {
    private static int hundlerId = 1;

    private IdGenerator() {
    }

    public static int generateHundlerId() {
        return hundlerId++;
    }
}
