
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class BreakfastTest {
    
    @Test
    public void populateOrderMapTestNorm() {
        String[] order = { "1", "2", "3" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put("Eggs", 1);
        test.put("Toast", 1);
        test.put("Coffee", 1);
        assertEquals(b.items, test);
    }

    @Test
    public void populateOrderMapTestMoreCoffee() {
        String[] order = { "1", "2", "3", "3", "3" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put("Eggs", 1);
        test.put("Toast", 1);
        test.put("Coffee", 3);
        assertEquals(b.items, test);
    }

    @Test
    public void populateOrderMapTestNoEggs() {
        String[] order = { "2", "3" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put("Toast", 1);
        test.put("Coffee", 1);
        assertEquals(b.items, test);
    }

    @Test
    public void printOrderTestNorm() {
        String[] order = { "1", "2", "3" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        String output = b.printOrder();
        String test = "Eggs, Toast, Coffee";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestWater() {
        String[] order = { "1", "2" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        String output = b.printOrder();
        String test = "Eggs, Toast, Water";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestMoreCoffee() {
        String[] order = { "1", "2", "3", "3", "3" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        String output = b.printOrder();
        String test = "Eggs, Toast, Coffee(3)";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoMain() {
        String[] order = { "2", "3" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        String output = b.printOrder();
        String test = "Unable to process: Main is missing";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoSide() {
        String[] order = { "1", "3" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        String output = b.printOrder();
        String test = "Unable to process: Side is missing";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoMainandSide() {
        String[] order = { "3", "3", "3" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        String output = b.printOrder();
        String test = "Unable to process: Main is missing, side is missing";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestMoreEggs() {
        String[] order = { "1", "1", "2", "3" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        String output = b.printOrder();
        String test = "Unable to process: Eggs cannot be ordered more than once";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestMoreToast() {
        String[] order = { "1", "2", "2", "3" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        String output = b.printOrder();
        String test = "Unable to process: Toast cannot be ordered more than once";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoEggsMoreToast() {
        String[] order = { "2", "2", "3" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        String output = b.printOrder();
        String test = "Unable to process: Toast cannot be ordered more than once";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestOutOfOrder() {
        String[] order = { "2", "1", "3" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        String output = b.printOrder();
        String test = "Eggs, Toast, Coffee";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestOutOfOrderMoreCoffee() {
        String[] order = { "3", "2", "3", "1", "3" };
        Breakfast b = new Breakfast(order);
        b.populateOrderMap();
        String output = b.printOrder();
        String test = "Eggs, Toast, Coffee(3)";
        assertEquals(output, test);
    }
}
