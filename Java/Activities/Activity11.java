package Activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args){
        HashMap<Integer,String> colours = new HashMap<Integer,String>();
        colours.put(1,"Red");
        colours.put(2,"Blue");
        colours.put(3,"Pink");
        colours.put(4,"Orange");
        colours.put(5,"Purple");
        System.out.println("Printing the Map: " +colours);
        String Value = colours.remove(3);
        System.out.println("Removed colour is: " +Value);
        boolean Value1 = colours.containsValue("Green");
        System.out.println("Checking if the colour green exists: " +Value1);
        System.out.println("Print the size of Map: " +colours.size());
    }
}
