package edu.epam.task4a.variables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class NumberArray {
    private static final Logger log = LogManager.getLogger(String.valueOf(NumberArray.class));

    private int[] numbers;

    public NumberArray(int... numbers) {
        this.numbers = numbers;
        log.info("NumberArray was created");
    }

    public NumberArray(int size) {
        this.numbers = new int[size];
        log.info("NumberArray was created");
    }

    public int[] getNumbers() {
        log.info("User get numbers");
        return numbers;
    }

    public int getNumber(int numberOfNumber) {
        if(numbers.length > numberOfNumber){
            log.info("User get " + numberOfNumber + " number");
            return numbers[numberOfNumber];
        }
        else {
            log.error("User try to get number out of array range");
            throw new IllegalArgumentException("Out of trains range");
        }
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
        log.info("User set numbers");
    }

    public void setNumber(int number) {
        int newPosition = numbers.length;
        this.numbers[newPosition] = number;
        log.info("User set number");
    }

    public void setNumberToPosition(int number,int position) {
        if(numbers.length < position) {
            this.numbers[position] = number;
            log.info("User set number");
        }
        else {
            log.error("User try to set number out of array range");
            throw new IllegalArgumentException("Out of trains range");
        }
    }

    @Override
    public int hashCode() {
        int code = 1;
        for(int i=0;i<numbers.length;i++) {
            code = 17 * code + numbers[i];
        }
        code = code*numbers.length;
        log.info("User get HashCode");
        return code;
    }

    @Override
    public boolean equals(Object numbersArray) {
        log.info("User compare arrays");
        if (this == numbersArray){
            log.info("Arrays equals");
            return true;
        }
        if (numbersArray == null || getClass() != numbersArray.getClass()){
            log.info("Arrays different");
            return false;
        }
        NumberArray arrayOfNumbers = (NumberArray) numbersArray;
        int[] firstNumbers =  arrayOfNumbers.numbers;
        int[] secondNumbers = this.numbers;
        if(firstNumbers.length == secondNumbers.length) {
            for (int i = 0;i<firstNumbers.length;i++){
                if(firstNumbers[i]!=secondNumbers[i]) {
                    log.info("Arrays different");
                    return false;
                }
            }
            log.info("Arrays equals");
            return true;
        }
        log.info("Arrays different");
        return false;
    }

    @Override
    public String toString() {
        String forOut = String.format("Numbers(%s) - %s",numbers.hashCode() ,Arrays.toString(numbers));
        log.info("User create string from Array");
        return forOut;
    }
}
