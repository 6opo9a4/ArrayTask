package edu.epam.task4b.variables;

public class ConstantValue {
    private final int MAX_RANDOM_VALUE = 10000;
    private final int MAX_BLOCK_SIZE = 9;
    private final int NUMBER_FOR_HASH_CODE = 17;

    public ConstantValue(){
    }

    public int getMaxRandomValue() {
        return MAX_RANDOM_VALUE;
    }

    public int getMaxBlockSize() {
        return MAX_BLOCK_SIZE;
    }

    public int getNUMBER_FOR_HASH_CODE() {
        return NUMBER_FOR_HASH_CODE;
    }
}
