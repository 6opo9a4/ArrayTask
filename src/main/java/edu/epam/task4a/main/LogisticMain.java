package edu.epam.task4a.main;

import edu.epam.task4a.service.ArrayService;
import edu.epam.task4a.variables.NumberArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class LogisticMain {
    private static final Logger log = LogManager.getLogger(String.valueOf(NumberArray.class));

    public static void main(String[] args) throws IOException {
        log.traceEntry("User start new main");
        NumberArray numberArray = new NumberArray(1,4,6,8,2,6);
        NumberArray expectedArray = new NumberArray(8,6,6,4,2,1);
        ArrayService arrayService = new ArrayService();
        NumberArray actualArray = new NumberArray(arrayService.bubbleSort(numberArray.getNumbers()));
        log.traceExit("User end main");
    }
}
