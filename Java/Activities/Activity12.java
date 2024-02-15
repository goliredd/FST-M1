package Activities;

import org.apache.commons.lang3.ClassUtils;

interface Addable{
    int add(int num1, int num2);
}

public class Activity12 {
    public static void main(String[] args){
    Addable ad1 = (num1, num2) -> (num1 + num2);
    System.out.println("Result of num1 plus num2 from ad1: " +ad1.add(10, 12));
    Addable ad2 = (int a, int b) -> {
            return (a + b);
    };
    System.out.println("Result of num1 plus num2 from ad2: " +ad2.add(120, 1000));
    }
}
