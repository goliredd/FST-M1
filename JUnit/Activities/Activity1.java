package Activities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class Activity1 {
    // Test Fixture
    static ArrayList<String> list;
    @BeforeEach
    public void setUp(){
        // Initialize a new ArrayList
        list = new ArrayList<String>();

        // Add values to the list
        list.add("alpha"); // at index 0
        list.add("beta"); // at index 1
    }
    @Test
    public void insertTest(){
        // Assert size of list
        assertEquals(2,list.size(),"Wrong size");
        // Add new value
        list.add("gamma");
        // Assert size of list after adding new value
        assertEquals(3,list.size(),"Wrong size");
        // Assert individual elements
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("beta", list.get(1), "Wrong element");
        assertEquals("gamma", list.get(2), "Wrong element");
    }
    @Test
    public void replaceTest(){
        //Assert size of list
        assertEquals(2,list.size(),"Wrong size");
        // Add new value
        list.add("gamma");
        // Assert size of list after adding new value
        assertEquals(3,list.size(),"Wrong size");
        // Replace element in ArrayList
        list.set(1,"lambda");
        // Assert individual elements
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("lambda", list.get(1), "Wrong element");
        assertEquals("gamma", list.get(2), "Wrong element");
    }

}
