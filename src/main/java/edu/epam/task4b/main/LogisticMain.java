package edu.epam.task4b.main;

import edu.epam.task4b.report.ResultsReport;
import edu.epam.task4b.service.ArrayService;
import edu.epam.task4b.variables.NumberArray;

import java.io.IOException;
import java.util.logging.Logger;

public class LogisticMain {
    private static final Logger log = Logger.getLogger(String.valueOf(edu.epam.task4a.variables.NumberArray.class));
    public static void main(String[] args) throws IOException {
        NumberArray numberArray;
        ArrayService arrayService =  new ArrayService();
        numberArray = new NumberArray(arrayService.generateRandomArray(10));
        ResultsReport report = new ResultsReport();
        report.numbersArrayOut(numberArray);
        NumberArray numberArray1 = new NumberArray(arrayService.bubbleSortBySum(numberArray.getNumbers()));
        report.numbersArrayOut(numberArray1);
        NumberArray numberArray2 = new NumberArray(arrayService.bubbleSortMax(numberArray.getNumbers()));
        report.numbersArrayOut(numberArray2);
        NumberArray numberArray3 = new NumberArray(arrayService.bubbleSortMin(numberArray.getNumbers()));
        report.numbersArrayOut(numberArray3);
    }
}
