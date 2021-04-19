javac Breakfast.java
javac Lunch.java
javac Dinner.java
javac Meal.java

javac -cp "C:\Users\jacob\OneDrive\Documents\Evive_engineering_test\junit4.jar;." BreakfastTest.java
java -cp "C:\Users\jacob\OneDrive\Documents\Evive_engineering_test\junit4.jar;." org.junit.runner.JUnitCore BreakfastTest
javac -cp "C:\Users\jacob\OneDrive\Documents\Evive_engineering_test\junit4.jar;." LunchT.java
java -cp "C:\Users\jacob\OneDrive\Documents\Evive_engineering_test\junit4.jar;." org.junit.runner.JUnitCore LunchT
javac -cp "C:\Users\jacob\OneDrive\Documents\Evive_engineering_test\junit4.jar;." DinnerTest.java
java -cp "C:\Users\jacob\OneDrive\Documents\Evive_engineering_test\junit4.jar;." org.junit.runner.JUnitCore DinnerTest

java Meal $args[0] $args[1]