package edu.epam.task4b.variables;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class NumberArray {
    private int[][] numbers;
    private static final Logger log = LogManager.getLogger(String.valueOf(edu.epam.task4a.variables.NumberArray.class));
    ConstantValue constantValue = new ConstantValue();
    public NumberArray(){
    }

    public NumberArray(int[][] numbers){
        this.numbers = numbers;
    }

    public int[][] getNumbers() {
        int[][] numbersTake=Arrays.copyOf(this.numbers, this.numbers.length);
        return numbersTake;
    }

    public int[] getBlock(int blockNumber){
        int[][] numbers = this.numbers;
        if(numbers.length>blockNumber){
            int[] numbersTake = Arrays.copyOf(numbers[blockNumber], numbers[blockNumber].length);
            return numbersTake;
        }
        else {
            log.error("Out of arrays range");
            throw new IllegalArgumentException("Out of arrays range");
        }

    }

    public int getNumber(int blockNumber, int position){
        int[][] numbers = this.numbers;
        if(numbers.length>blockNumber && numbers[blockNumber].length>position){
            return numbers[blockNumber][position];
        }
        else {
            log.error("Out of arrays range");
            throw new IllegalArgumentException("Out of arrays range");
        }
    }

    public void setNumbers(int[][] numbers) {
        this.numbers = numbers;
    }

    public void setBlockNumbers(int[] numbers, int blockNumber){
        if(numbers.length>blockNumber){
            this.numbers[blockNumber] = numbers;
        }
    }

    public void setNumber(int number, int blockNumber, int position){
        int[][] numbers = this.numbers;
        if(numbers.length>blockNumber && numbers[blockNumber].length>position){
            this.numbers[blockNumber][position] = number;
        }
        else {
            log.error("Out of arrays range");
            throw new IllegalArgumentException("Out of arrays range");
        }
    }

    @Override
    public int hashCode() {
        int code = 1;
        for(int i=0;i<numbers.length;i++) {
            for(int z=0;z<numbers[i].length;i++){
                code = constantValue.getNUMBER_FOR_HASH_CODE() * code + numbers[i][z];
            }
        }
        code = code*numbers.length;
        log.info("User get HashCode");
        return code;
    }

    @Override
    public boolean equals(Object numbersArray) {
        log.info("User compare numberArrays");
        if (this == numbersArray){
            log.info("Arrays equals");
            return true;
        }
        if (numbersArray == null || getClass() != numbersArray.getClass()){
            log.info("Arrays not same");
            return false;
        }
        NumberArray arrayOfNumbers = (NumberArray) numbersArray;
        int[][] firstNumbers =  arrayOfNumbers.numbers;
        int[][] secondNumbers = this.numbers;
        if(firstNumbers.length == secondNumbers.length) {
            for (int i = 0;i<firstNumbers.length;i++){
                if(firstNumbers[i].length!=secondNumbers[i].length) {
                    log.info("Arrays not same");
                    return false;
                }
            }
            for(int i=0;i<numbers.length;i++) {
                for(int z=0;z<numbers[i].length;z++) {
                    if(firstNumbers[i][z]!=secondNumbers[i][z]){
                        log.info("Arrays not same");
                        return false;
                    }
                }
            }
            log.info("Arrays equals");
            return true;
        }
        log.info("Arrays not same");
        return false;
    }

    @Override
    public String toString() {
        String forOut = String.format("Numbers: ");
        for(int i=0;i<numbers.length;i++) {
            forOut = String.format("%s \n %s" ,forOut,Arrays.toString(numbers[i]));
        }
        return forOut;
    }
}
