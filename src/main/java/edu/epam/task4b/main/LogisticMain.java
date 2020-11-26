package edu.epam.task4b.main;

import edu.epam.task4b.report.ResultsReport;
import edu.epam.task4b.service.ArrayService;
import edu.epam.task4b.variables.NumberArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogisticMain {
    private static final Logger log = LogManager.getLogger(String.valueOf(LogisticMain.class));
    public static void main(String[] args){
        log.traceEntry("User start new main");
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
        log.traceExit("User exit main");
    }
}
