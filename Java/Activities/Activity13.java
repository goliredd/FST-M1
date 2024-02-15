package Activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random indexGen = new Random();
        System.out.println("Please enter integer values: ");
        System.out.println("Accepts only integer values & terminates for non-integer values");
        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }
        Integer nums[] = list.toArray(new Integer[0]);
        int index = indexGen.nextInt(nums.length);
        System.out.println("Printing index value that was generated: " +index);
        System.out.println("value in the array at that index value: " +nums[index]);
    }
}
