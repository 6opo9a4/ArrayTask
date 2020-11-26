package edu.epam.task4a.service;

import edu.epam.task4a.variables.NumberArray;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ArrayServiceTest {
    @Test
    public void bubbleSortTest(){
        NumberArray numberArray = new NumberArray(1,4,6,8,2,6);
        NumberArray expectedArray = new NumberArray(8,6,6,4,2,1);
        ArrayService arrayService = new ArrayService();
        NumberArray actualArray = new NumberArray(arrayService.bubbleSort(numberArray.getNumbers()));
        Assert.assertEquals(expectedArray,actualArray);
    }

    @Test
    public void shuttleSortTest(){
        NumberArray numberArray = new NumberArray(1,4,6,8,2,6);
        NumberArray expectedArray = new NumberArray(8,6,6,4,2,1);
        ArrayService arrayService = new ArrayService();
        NumberArray actualArray = new NumberArray(arrayService.shuttleSort(numberArray.getNumbers()));
        Assert.assertEquals(expectedArray,actualArray);
    }

    @Test
    public void shellSortTest(){
        NumberArray numberArray = new NumberArray(1,4,6,8,2,6);
        NumberArray expectedArray = new NumberArray(8,6,6,4,2,1);
        ArrayService arrayService = new ArrayService();
        NumberArray actualArray = new NumberArray(arrayService.shellSort(numberArray.getNumbers()));
        Assert.assertEquals(expectedArray,actualArray);
    }

    @Test
    public void binarySearch(){
        NumberArray numberArray = new NumberArray(1,4,6,8,2,6,12,0);
        int expectedNumber = 8;
        ArrayService arrayService = new ArrayService();
        int actualNumber = arrayService.binarySearch(numberArray.getNumbers(),expectedNumber);
        Assert.assertEquals(expectedNumber,actualNumber);
    }

    @Test
    public void maxSearch(){
        NumberArray numberArray = new NumberArray(1,4,6,8,2,6,12,0);
        int expectedNumber = 12;
        ArrayService arrayService = new ArrayService();
        int actualNumber = arrayService.maxSearch(numberArray.getNumbers());
        Assert.assertEquals(expectedNumber,actualNumber);
    }

    @Test
    public void minSearch(){
        NumberArray numberArray = new NumberArray(1,4,6,8,2,6,12,0);
        int expectedNumber = 0;
        ArrayService arrayService = new ArrayService();
        int actualNumber = arrayService.minSearch(numberArray.getNumbers());
        Assert.assertEquals(expectedNumber,actualNumber);
    }
    @Test
    public void findPrime(){
        NumberArray numberArray = new NumberArray(1,3,9,7,2,6,5,21,31);
        NumberArray expectedArray = new NumberArray(3,7,5,31);
        ArrayService arrayService = new ArrayService();
        NumberArray actualArray = new NumberArray(arrayService.isPrime(numberArray.getNumbers()));
        Assert.assertEquals(expectedArray,actualArray);
    }

    @Test
    public void fibonacciNumbers(){
        NumberArray numberArray = new NumberArray(1,3,9,7,2,6,5,21,31,8);
        NumberArray expectedArray = new NumberArray(1,3,2,5,21,8);
        ArrayService arrayService = new ArrayService();
        NumberArray actualArray = new NumberArray(arrayService.fibonacciNumbers(numberArray.getNumbers()));
        Assert.assertEquals(expectedArray,actualArray);
    }

    @Test
    public void threeDigitWithoutRepeats(){
        NumberArray numberArray = new NumberArray(100,3234,999,723,221,639,515,210,31,888);
        NumberArray expectedArray = new NumberArray(723,639,210);
        ArrayService arrayService = new ArrayService();
        NumberArray actualArray = new NumberArray(arrayService.threeDigitWithoutRepeats(numberArray.getNumbers()));
        Assert.assertEquals(expectedArray,actualArray);
    }

    @Test
    public void writeReadFile() throws IOException {
        NumberArray expectedArray = new NumberArray(100,3234,998,723,221,639,515,210,31,888);
        ArrayService arrayService = new ArrayService();
        arrayService.writeToFile("numbers",expectedArray.getNumbers());
        NumberArray actualArray = new NumberArray(arrayService.readFromFile("numbers"));
        Assert.assertEquals(expectedArray,actualArray);
    }
}