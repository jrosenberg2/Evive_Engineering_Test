
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class DinnerTest {
    
    @Test
    public void populateOrderMapTestNorm() {
        String[] order = { "1", "2", "3", "4" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put("Steak", 1);
        test.put("Potatoes", 1);
        test.put("Wine", 1);
        test.put("Cake", 1);
        assertEquals(d.items, test);
    }

    @Test
    public void populateOrderMapTestMoreSide() {
        String[] order = { "1", "2", "2", "2", "3", "4" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put("Steak", 1);
        test.put("Potatoes", 3);
        test.put("Wine", 1);
        test.put("Cake", 1);
        assertEquals(d.items, test);
    }

    @Test
    public void populateOrderMapTestNoMain() {
        String[] order = { "2", "3", "4" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put("Potatoes", 1);
        test.put("Wine", 1);
        test.put("Cake", 1);
        assertEquals(d.items, test);
    }

    @Test
    public void printOrderTestNorm() {
        String[] order = { "1", "2", "3", "4" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        String output = d.printOrder();
        String test = "Steak, Potatoes, Wine, Water, Cake";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestWater() {
        String[] order = { "1", "2", "4" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        String output = d.printOrder();
        String test = "Steak, Potatoes, Water, Cake";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestMoreSide() {
        String[] order = { "1", "2", "2", "2", "3" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        String output = d.printOrder();
        String test = "Unable to process: Potatoes cannot be ordered more than once";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoMain() {
        String[] order = { "2", "3", "4" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        String output = d.printOrder();
        String test = "Unable to process: Main is missing";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoSide() {
        String[] order = { "1", "3", "4" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        String output = d.printOrder();
        String test = "Unable to process: Side is missing";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoMainandSideandMoreSoda() {
        String[] order = { "3", "3", "3" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        String output = d.printOrder();
        String test = "Unable to process: Wine cannot be ordered more than once";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoMainandSide() {
        String[] order = { "3", "4" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        String output = d.printOrder();
        String test = "Unable to process: Main is missing, side is missing";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoMainSideDessert() {
        String[] order = { "3" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        String output = d.printOrder();
        String test = "Unable to process: Main is missing, side is missing, dessert is missing";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestMoreMain() {
        String[] order = { "1", "1", "2", "3", "4" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        String output = d.printOrder();
        String test = "Unable to process: Steak cannot be ordered more than once";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestMoreDrink() {
        String[] order = { "1", "2", "3", "3", "4" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        String output = d.printOrder();
        String test = "Unable to process: Wine cannot be ordered more than once";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestNoSideNoDessertMoreMain() {
        String[] order = { "1", "1", "3" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        String output = d.printOrder();
        String test = "Unable to process: Steak cannot be ordered more than once";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestOutOfOrder() {
        String[] order = { "4", "2", "1", "3" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        String output = d.printOrder();
        String test = "Steak, Potatoes, Wine, Water, Cake";
        assertEquals(output, test);
    }

    @Test
    public void printOrderTestOutOfOrderMoreSide() {
        String[] order = { "2", "3", "4", "2", "1", "2" };
        Dinner d = new Dinner(order);
        d.populateOrderMap();
        String output = d.printOrder();
        String test = "Unable to process: Potatoes cannot be ordered more than once";
        assertEquals(output, test);
    }

}
