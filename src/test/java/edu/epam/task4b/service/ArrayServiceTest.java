package edu.epam.task4b.service;

import edu.epam.task4b.variables.NumberArray;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class ArrayServiceTest {

    @Test
    public void testBubbleSortBySumToMin() {
        int[][] startArray = {{1,2,3,4,5,6,7}, {169,120,150}, {12,23,67,32,76}};
        int[][] expected = {{169,120,150}, {12,23,67,32,76}, {1,2,3,4,5,6,7}};
        NumberArray expectedArray = new NumberArray(expected);
        ArrayService arrayService = new ArrayService();
        int[][] actual = arrayService.bubbleSortBySum(startArray);
        NumberArray actualArray = new NumberArray(actual);
        Assert.assertEquals(expectedArray,actualArray);
    }
    @Test
    public void testBubbleSortBySumToMax() {
        int[][] startArray = {{1,2,3,4,5,6,7}, {169,120,150}, {12,23,67,32,76}};
        int[][] expected = { {1,2,3,4,5,6,7}, {12,23,67,32,76},{169,120,150}};
        NumberArray expectedArray = new NumberArray(expected);
        ArrayService arrayService = new ArrayService();
        int[][] firstSort = arrayService.bubbleSortBySum(startArray);
        int[][] actual = arrayService.bubbleSortBySum(firstSort);
        NumberArray actualArray = new NumberArray(actual);
        Assert.assertEquals(expectedArray,actualArray);
    }

    @Test
    public void testBubbleSortMaxElement() {
        int[][] startArray = {{1,2,3,4,5,6,7}, {169,120,150}, {12,23,67,32,76}};
        int[][] expected = { {1,2,3,4,5,6,7}, {12,23,67,32,76},{169,120,150}};
        NumberArray expectedArray = new NumberArray(expected);
        ArrayService arrayService = new ArrayService();
        int[][] firstSort = arrayService.bubbleSortMax(startArray);
        int[][] actual = arrayService.bubbleSortMax(firstSort);
        NumberArray actualArray = new NumberArray(actual);
        Assert.assertEquals(expectedArray,actualArray);
    }

    @Test
    public void testBubbleSortMinElement() {
        int[][] startArray = {{1,2,3,4,5,6,7}, {169,120,150}, {12,23,67,32,76}};
        int[][] expected = { {1,2,3,4,5,6,7}, {12,23,67,32,76},{169,120,150}};
        NumberArray expectedArray = new NumberArray(expected);
        ArrayService arrayService = new ArrayService();
        int[][] firstSort = arrayService.bubbleSortMin(startArray);
        int[][] actual = arrayService.bubbleSortMin(firstSort);
        NumberArray actualArray = new NumberArray(actual);
        Assert.assertEquals(expectedArray,actualArray);
    }
}