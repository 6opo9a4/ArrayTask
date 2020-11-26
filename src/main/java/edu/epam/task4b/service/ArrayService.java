package edu.epam.task4b.service;

import edu.epam.task4b.variables.ConstantValue;
import edu.epam.task4b.variables.NumberArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayService {
    private static final Logger log = LogManager.getLogger(String.valueOf(NumberArray.class));
    ConstantValue constantValue = new ConstantValue();

    public int[][] bubbleSortBySum(int[][] numbers){
        if(numbers.length<2) {
            log.error("Array size to little");
            throw new IllegalArgumentException("you must add more blocks to sort");
        }
        else {
            int[] sums = blockSums(1,numbers);
            boolean needIteration = true;
            if(sums[0]>sums[1]) {
                while (needIteration) {
                    needIteration = false;
                    for (int i = 1; i < numbers.length; i++) {
                        sums = blockSums(i,numbers);
                        if (sums[0] > sums[1]) {
                            changePlaces(i,numbers);
                            needIteration = true;
                        }
                    }
                }
            }
            else{
                while (needIteration) {
                    needIteration = false;
                    for (int i = 1; i < numbers.length; i++) {
                        sums = blockSums(i,numbers);
                        if (sums[0] < sums[1]) {
                            changePlaces(i,numbers);
                            needIteration = true;
                        }
                    }
                }
            }
            log.info("User use bubble sort by sum");
            return numbers;
        }
    }

    public int[][] bubbleSortMax(int[][] numbers){
        if(numbers.length<2) {
            throw new IllegalArgumentException("you must add more numbers to sort");
        }
        else {
            int[] maxes = blocksMax(1,numbers);
            boolean needIteration = true;
            if(maxes[0] > maxes[1]) {
                while (needIteration) {
                    needIteration = false;
                    for (int i = 1; i < numbers.length; i++) {
                        maxes = blocksMax(i,numbers);
                        if (maxes[0] > maxes[1]) {
                            changePlaces(i,numbers);
                            needIteration = true;
                        }
                    }
                }
            }
            else{
                while (needIteration) {
                    needIteration = false;
                    for (int i = 1; i < numbers.length; i++) {
                        maxes = blocksMax(i,numbers);
                        if (maxes[0] < maxes[1]) {
                            changePlaces(i,numbers);
                            needIteration = true;
                        }
                    }
                }
            }
            log.info("User use bubble sort by max");
            return numbers;
        }
    }

    public int[][] bubbleSortMin(int[][] numbers){
        if(numbers.length<2) {
            throw new IllegalArgumentException("you must add more numbers to sort");
        }
        else {
            int[] mines = blocksMin(1,numbers);
            boolean needIteration = true;
            if(mines[0] > mines[1]) {
                while (needIteration) {
                    needIteration = false;
                    for (int i = 1; i < numbers.length; i++) {
                        mines = blocksMin(i,numbers);
                        if (mines[0] > mines[1]) {
                            changePlaces(i,numbers);
                            needIteration = true;
                        }
                    }
                }
            }
            else{
                while (needIteration) {
                    needIteration = false;
                    for (int i = 1; i < numbers.length; i++) {
                        mines = blocksMin(i,numbers);
                        if (mines[0] < mines[1]) {
                            changePlaces(i,numbers);
                            needIteration = true;
                        }
                    }
                }
            }
            log.info("User use bubble sort by min");
            return numbers;
        }
    }

    public int[][] generateRandomArray(int size){
        int number = (int) ( Math.random() * 10000);
        int[][] generatedArray = new int[size][];
        for (int i = 0;i<size;i++){
            int blockSize = (int) ( Math.random() * constantValue.getMaxBlockSize() + 1);
            int[] block = new int[blockSize];
            for(int z =0;z<blockSize;z++){
                block[z] = (int) ( Math.random() * constantValue.getMaxRandomValue());
            }
            generatedArray[i] = block;
        }
        log.info("User generate first array");
        return generatedArray;
    }

    private int[] blockSums(int i, int[][] numbers){
        int[] sums = new  int[2];
        int[] block1 = numbers[i-1];
        int[] block2 = numbers[i];
        int sum1=0;
        int sum2=0;
        for(int z = 0;z<block1.length;z++){
            sum1 = sum1 + block1[z];
        }
        for(int z = 0;z<block2.length;z++){
            sum2 = sum2 + block2[z];
        }
        sums[0] = sum1;
        sums[1] = sum2;
        return sums;
    }

    private int[] blocksMin(int z, int[][] numbers){
        int min1;
        int min2;
        if(numbers.length == 0){
            throw new IllegalArgumentException("Your array is empty");
        }
        else {
            min1 = numbers[z-1][0];
            min2 = numbers[z][0];
            for (int i = 0;i<numbers[z-1].length;i++)
            {
                if(min1>numbers[z-1][i]){
                    min1 = numbers[z-1][i];
                }
            }
            for (int i = 0;i<numbers[z].length;i++)
            {
                if(min2>numbers[z][i]){
                    min2 = numbers[z][i];
                }
            }
        }
        int[] mines = new int[2];
        mines[0] = min1;
        mines[1] = min2;
        return mines;
    }

    private int[] blocksMax(int z,int[][] numbers){
        int max1;
        int max2;
        if(numbers.length == 0){
            throw new IllegalArgumentException("Your array is empty");
        }
        else {
            max1 = numbers[z-1][0];
            max2 = numbers[z][0];
            for (int i = 0;i<numbers[z-1].length;i++)
            {
                if(max1<numbers[z-1][i]){
                    max1 = numbers[z-1][i];
                }
            }
            for (int i = 0;i<numbers[z].length;i++)
            {
                if(max2<numbers[z][i]){
                    max2 = numbers[z][i];
                }
            }
        }
        int[] mines = new int[2];
        mines[0] = max1;
        mines[1] = max2;
        return mines;
    }

    private void changePlaces(int i, int[][] numbers){
        int[] tmp = numbers[i];
        numbers[i] = numbers[i-1];
        numbers[i-1] = tmp;
    }
}
