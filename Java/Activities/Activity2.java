package Activities;

import java.util.Arrays;

public class Activity2 {
    public static void main(String[] args){
        int[] arrayNum = {10,77, 10, 54, -11, 10};
        System.out.println("Array: " +Arrays.toString(arrayNum));
        int findTens = 10;
        int finalSum = 30;
        System.out.println("Result: " +result(arrayNum, findTens, finalSum));
        }
    public static boolean result(int[] numbers, int findTens, int finalSum){
        int tempSum = 0;
        for(int num : numbers) {
            if(num == findTens){
                tempSum+= findTens;
            }
            if(tempSum > finalSum) break;
        }
        return tempSum == finalSum;
    }
    }
