
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
public class LunchT {
    
    @Test
    public void populateOrderMapTestNorm() {
        String[] order = { "1", "2", "3" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put("Salad", 1);
        test.put("Chips", 1);
        test.put("Soda", 1);
        assertEquals(l.items, test);
    }

    @Test
    public void populateOrderMapTestMoreChips() {
        String[] order = { "1", "2", "2", "2", "3" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put("Salad", 1);
        test.put("Chips", 3);
        test.put("Soda", 1);
        assertEquals(l.items, test);
    }

    @Test
    public void populateOrderMapTestNoMain() {
        String[] order = { "2", "3" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put("Chips", 1);
        test.put("Soda", 1);
        assertEquals(l.items, test);
    }

    @Test
    public void printOrderTestNorm() {
        String[] order = { "1", "2", "3" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        String output = l.printOrder();
        String test = "Salad, Chips, Soda";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestWater() {
        String[] order = { "1", "2" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        String output = l.printOrder();
        String test = "Salad, Chips, Water";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestMoreChips() {
        String[] order = { "1", "2", "2", "2", "3" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        String output = l.printOrder();
        String test = "Salad, Chips(3), Soda";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoMain() {
        String[] order = { "2", "3" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        String output = l.printOrder();
        String test = "Unable to process: Main is missing";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoSide() {
        String[] order = { "1", "3" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        String output = l.printOrder();
        String test = "Unable to process: Side is missing";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoMainandSideandMoreSoda() {
        String[] order = { "3", "3", "3" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        String output = l.printOrder();
        String test = "Unable to process: Soda cannot be ordered more than once";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoMainandSide() {
        String[] order = { "3" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        String output = l.printOrder();
        String test = "Unable to process: Main is missing, side is missing";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestMoreMain() {
        String[] order = { "1", "1", "2", "3" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        String output = l.printOrder();
        String test = "Unable to process: Salad cannot be ordered more than once";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestMoreDrink() {
        String[] order = { "1", "2", "3", "3" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        String output = l.printOrder();
        String test = "Unable to process: Soda cannot be ordered more than once";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoSideMoreMain() {
        String[] order = { "1", "1", "3" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        String output = l.printOrder();
        String test = "Unable to process: Salad cannot be ordered more than once";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestOutOfOrder() {
        String[] order = { "2", "1", "3" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        String output = l.printOrder();
        String test = "Salad, Chips, Soda";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestOutOfOrderMoreSide() {
        String[] order = { "2", "3", "2", "1", "2" };
        Lunch l = new Lunch(order);
        l.populateOrderMap();
        String output = l.printOrder();
        String test = "Salad, Chips(3), Soda";
        assertEquals(output, test);
    }
}
