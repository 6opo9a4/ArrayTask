package edu.epam.task4b.variables;

import java.util.Arrays;

public class NumberArray {
    private int[][] numbers;

    public NumberArray(){

    }
    public NumberArray(int[][] numbers){
        this.numbers = numbers;
    }

    public int[][] getNumbers() {
        return numbers;
    }

    public int[] getBlock(int blockNumber){
        int[][] numbers = this.numbers;
        if(numbers.length>blockNumber){
            return numbers[blockNumber];
        }
        else {
            throw new IllegalArgumentException("Out of arrays range");
        }

    }

    public int getNumber(int blockNumber, int position){
        int[][] numbers = this.numbers;
        if(numbers.length>blockNumber && numbers[blockNumber].length>position){
            return numbers[blockNumber][position];
        }
        else {
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
            throw new IllegalArgumentException("Out of arrays range");
        }
    }

    @Override
    public boolean equals(Object numbersArray) {
        if (this == numbersArray){
            return true;
        }
        if (numbersArray == null || getClass() != numbersArray.getClass()){
            return false;
        }
        NumberArray arrayOfNumbers = (NumberArray) numbersArray;
        int[][] firstNumbers =  arrayOfNumbers.numbers;
        int[][] secondNumbers = this.numbers;
        if(firstNumbers.length == secondNumbers.length) {
            for (int i = 0;i<firstNumbers.length;i++){
                if(firstNumbers[i].length!=secondNumbers[i].length) {
                    return false;
                }
            }
            for(int i=0;i<numbers.length;i++) {
                for(int z=0;z<numbers[i].length;z++) {
                    if(firstNumbers[i][z]!=secondNumbers[i][z]){
                        return false;
                    }
                }
            }
            return true;
        }
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
