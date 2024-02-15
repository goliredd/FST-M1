package Activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("Tiger");
        hs.add("Dog");
        hs.add("Cat");
        hs.add("Lion");
        hs.add("Horse");
        hs.add("Cow");
        System.out.println(STR."Print the size of HashSet: \{hs.size()}");
        System.out.println(STR."Remove an element present in HashSet: \{hs.remove("Cow")}");
        System.out.println(STR."Remove an element not present in HashSet: \{hs.remove("Camel")}");
        System.out.println(STR."Check an element present or not in HashSet: \{hs.contains("Cat")}");
        System.out.println("Print the updated set");
        for(String s:hs){
            System.out.println(s);
        }
    }
}