package edu.epam.task4a.service;

import edu.epam.task4a.variables.ConstantValue;
import edu.epam.task4a.variables.NumberArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayService {
    private static final Logger log = LogManager.getLogger(String.valueOf(NumberArray.class));
    ConstantValue constant =  new ConstantValue();

    public int[] bubbleSort(int[] numbers){
        if(numbers.length<2) {
            log.error("Array size to little");
            throw new IllegalArgumentException("you must add more numbers to sort");
        }
        else {
            int number1 = numbers[0];
            int number2 = numbers[1];
            boolean needIteration = true;
            if(number1<number2) {
                while (needIteration) {
                    needIteration = false;
                    for (int i = 1; i < numbers.length; i++) {
                        number1 = numbers[i];
                        number2 = numbers[i - 1];
                        if (number1 > number2) {
                            int tmp = number1;
                            numbers[i] = number2;
                            numbers[i-1] = tmp;
                            needIteration = true;
                        }
                    }
                }
            }
            else{
                while (needIteration) {
                    needIteration = false;
                    for (int i = 1; i < numbers.length; i++) {
                        number1 = numbers[i];
                        number2 = numbers[i - 1];
                        if (number1 < number2) {
                            int tmp = number1;
                            numbers[i] = number2;
                            numbers[i-1] = tmp;
                            needIteration = true;
                        }
                    }
                }
            }
            log.info("Sorted with bubbles");
            return numbers;
        }
    }

    public int[] shuttleSort(int[] numbers){
        if(numbers.length<2) {
            log.error("Array size to little");
            throw new IllegalArgumentException("you must add more numbers to sort");
        }
        else {
            int number1 = numbers[0];
            int numbre2 = numbers[1];
            if(number1 < numbre2) {
                for (int i = 1; i < numbers.length; i++) {
                    number1 = numbers[i];
                    numbre2 = numbers[i - 1];
                    if (number1 > numbre2) {
                        int tmp = number1;
                        numbers[i] = numbre2;
                        numbers[i-1] = tmp;
                        for (int z = i - 1; (z - 1) >= 0; z--) {
                            number1 = numbers[z];
                            numbre2 = numbers[z - 1];
                            if (number1 > numbre2) {
                                tmp = number1;
                                numbers[z] = numbre2;
                                numbers[z-1] = tmp;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            else{
                for (int i = 1; i < numbers.length; i++) {
                    number1 = numbers[i];
                    numbre2 = numbers[i - 1];
                    if (number1 < numbre2) {
                        int tmp = number1;
                        numbers[i] = numbre2;
                        numbers[i-1] = tmp;
                        for (int z = i - 1; (z - 1) >= 0; z--) {
                            number1 = numbers[z];
                            numbre2 = numbers[z - 1];
                            if (number1 < numbre2) {
                                tmp = number1;
                                numbers[z] = numbre2;
                                numbers[z-1] = tmp;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            log.info("Sorted with shuttle");
            return numbers;
        }
    }
    public int[] shellSort(int[] numbers){
        if(numbers.length<2) {
            log.error("Array size to little");
            throw new IllegalArgumentException("you must add more numbers to sort");
        }
        else {
            int number1= numbers[0];
            int number2 = numbers[1];
            if(number1 > number2) {
                int gap = numbers.length / 2;
                while (gap >= 1) {
                    for (int right = 0; right < numbers.length; right++) {
                        for (int c = right - gap; c >= 0; c -= gap) {
                            number1 = numbers[c];
                            number2 = numbers[c+gap];
                            if (numbers[c] > numbers[c + gap]) {
                                int tmp = number1;
                                numbers[c] = number2;
                                numbers[c+gap] = tmp;
                            }
                        }
                    }
                    gap = gap / 2;
                }
            }
            else{
                int gap = numbers.length / 2;
                while (gap >= 1) {
                    for (int right = 0; right < numbers.length; right++) {
                        for (int c = right - gap; c >= 0; c -= gap) {
                            number1 = numbers[c];
                            number2 = numbers[c+gap];
                            if (numbers[c] < numbers[c + gap]) {
                                int tmp = number1;
                                numbers[c] = number2;
                                numbers[c+gap] = tmp;
                            }
                        }
                    }
                    gap = gap / 2;
                }
            }
            log.info("Sorted with shell");
            return numbers;
        }
    }

    public int binarySearch(int numbers[], int elementToSearch) {
        log.info("User start binary search");
        int firstPoint = 0;
        int lastPoint = numbers.length - 1;
        while(firstPoint <= lastPoint) {
            int middlePoint = (firstPoint + lastPoint) / 2;
            if (numbers[middlePoint] == elementToSearch) {
                log.info("User found " + numbers[middlePoint]);
                return numbers[middlePoint];
            }
            if (numbers[middlePoint] < elementToSearch){
                firstPoint = middlePoint + 1;
            }
            if (numbers[middlePoint] > elementToSearch){
                lastPoint = middlePoint - 1;
            }
        }
        log.error("No such element");
        throw new IllegalArgumentException("No such element in array");
    }

    public int minSearch(int[] numbers){
        int min;
        if(numbers.length == 0){
            log.error("Array was empty");
            throw new IllegalArgumentException("Your array is empty");
        }
        else {
            min = numbers[0];
            for (int i = 0;i<numbers.length;i++)
            {
                if(min>numbers[i]){
                    min = numbers[i];
                }
            }
        }
        log.info("User found min element:" + min);
        return min;
    }

    public int maxSearch(int[] numbers){
        int max;
        if(numbers.length == 0){
            log.error("Array was empty");
            throw new IllegalArgumentException("Your array is empty");
        }
        else {
            max = numbers[0];
            for (int i = 0;i<numbers.length;i++)
            {
                if(max<numbers[i]){
                    max = numbers[i];
                }
            }
        }
        log.info("User found max element:" + max);
        return max;
    }

    public int[] isPrime(int[] numbers) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        if(numbers.length == 0){
            log.error("Array was empty");
            throw new IllegalArgumentException("Your array is empty");
        }
        else {
            for(int z = 0;z<numbers.length;z++)
            {
                if (numbers[z]%2!=0){
                    for(int i=3;i<=numbers[z];i+=2) {
                        if (numbers[z] % i != 0 || numbers[z] == i) {
                            primeNumbers.add(numbers[z]);
                        }
                        break;
                    }
                }
            }
        }
        int[] primeResult = fromArray(primeNumbers);
        log.info("User take prime numbers");
        return primeResult;
    }

    public int[] fibonacciNumbers(int[] numbers){
        if(numbers.length == 0){
            log.error("Array was empty");
            throw new IllegalArgumentException("Your array is empty");
        }
        int maxElement = maxSearch(numbers);
        ArrayList<Integer> fibonacci =  new ArrayList<>();
        ArrayList<Integer> fibonacciFromNumbers = new ArrayList<>();
        int n0 = 1;
        int n1 = 1;
        int n2=1;
        fibonacci.add(n0);
        do{
            n2=n0+n1;
            fibonacci.add(n2);
            n0=n1;
            n1=n2;
        } while (n2<maxElement);
        for (int i=0;i<numbers.length;i++){
            for(int z = 0;z<fibonacci.size();z++){
                if(numbers[i]==fibonacci.get(z)){
                    fibonacciFromNumbers.add(numbers[i]);
                }
            }
        }
        int[] fibonacciResult = fromArray(fibonacciFromNumbers);
        log.info("User take fibonacci numbers");
        return fibonacciResult;
    }

    public int[] threeDigitWithoutRepeats(int[] numbers){
        if(numbers.length == 0){
            log.error("Array was empty");
            throw new IllegalArgumentException("Your array is empty");
        }
        ArrayList<Integer> resultList =  new ArrayList<>();
        int[] result;
        for(int i = 0;i<numbers.length;i++){
            if(numbers[i]/100>0 && numbers[i]/100<10){
                String number = Integer.toString(numbers[i]);
                char[] digitsOfNumber = number.toCharArray();
                if(digitsOfNumber[0]!=digitsOfNumber[1] && digitsOfNumber[0]!=digitsOfNumber[2] && digitsOfNumber[1]!=digitsOfNumber[2]){
                    resultList.add(numbers[i]);
                }
            }
        }
        result = fromArray(resultList);
        log.info("User take three-digit-without-repeats numbers");
        return result;
    }

    public int[] generateRandomArray(){
        int size = (int) ( Math.random() * 101);
        int[] generatedArray = new int[size];
        for (int i = 0;i<size;i++){
            int number = (int) ( Math.random() * 10000);
            generatedArray[i] = number;
        }
        log.info("User generate random array");
        return generatedArray;
    }

    public void writeToFile (String filename,int[] numbers) {
        BufferedWriter outputWriter;
        try {
            outputWriter = new BufferedWriter(new FileWriter(constant.getFILE_PATH()+filename+".txt"));
            outputWriter.write("");
            for (int i = 0; i < numbers.length; i++) {
                outputWriter.write(Integer.toString(numbers[i]));
                outputWriter.newLine();
            }
            outputWriter.flush();
            outputWriter.close();
        } catch (IOException e) {
            log.error("Error: " + e.getMessage());
        }
    }

    public int[] readFromFile(String filename) {
        Scanner s = null;
        int[] numbers =  new int[]{};
        try {
            s = new Scanner(new File(constant.getFILE_PATH()+filename + ".txt"));
            ArrayList<Integer> arrayOfNumbers = new ArrayList<>();
            while (s.hasNext()){
               arrayOfNumbers.add(s.nextInt());
            }
            numbers = fromArray(arrayOfNumbers);
            log.info("User read from file");
        } catch (FileNotFoundException e) {
            log.error("Error: " + e.getMessage());
        }finally {
            s.close();
        }
        return numbers;
    }

    private int[] fromArray(ArrayList<Integer> initNumbers){
        int[] intResult = new int[initNumbers.size()];
        for(int i = 0; i < initNumbers.size(); i++) {
            if (initNumbers.get(i) != null) {
                intResult[i] = initNumbers.get(i);
            }
        }
        return intResult;
    }
}
