package Activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Mango");
        myList.add("Kiwi");
        myList.add(4,"Cherry");

        System.out.println("Print all the names");
        for(String s:myList){
            System.out.println(s);
        }
        System.out.println(STR."Get 3rd name in the ArrayList: \{myList.get(2)}");
        System.out.println(STR."Check if Kiwi exists: \{myList.contains("Kiwi")}");
        System.out.println(STR."Print the number of names: \{myList.size()}");
        System.out.println(STR."Remove Kiwi 4th item from the list:\{myList.remove(3)}");
        System.out.println(STR."Print the number of names: \{myList.size()}");
    }
}
