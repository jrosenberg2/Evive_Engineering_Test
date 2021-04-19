Jacob Rosenberg
4/18/2021
Evive Engineering Test

File Descriptions:
Breakfast.java - Creates a breakfast meal from an order if the order is valid. If the order is valid, it returns the contents of the order. If the order is invalid, it returns an error message
Lunch.java - Creates a lunch meal from an order if the order is valid. If the order is valid, it returns the contents of the order. If the order is invalid, it returns an error message
Dinner.java - Creates a dinner meal from an order if the order is valid. If the order is valid, it returns the contents of the order. If the order is invalid, it returns an error message
Meal.java - Takes user input for an order of any meal type. Calls Breakfast.java, Lunch.java, or Dinner.java. If the order is valid, it prints the contents of the order. If the order is invalid, it prints an error message
build.ps1 - Powershell script to compile all of our files, run our tests, and run a single case input by the user

junit4.jar - junit.jar file. put in this folder for ease of finding and using the file path to run tests

BreakfastTest.java - A java JUnit test file that tests breakfast methods and output possibilities
BreakfastTest.java - A java JUnit test file that tests lunch methods and output possibilities
BreakfastTest.java - A java JUnit test file that tests dinner methods and output possibilities

How TO RUN BuildScript:
1. Open Folder in VSCode
2. Ensure you have a recent version of Java (at least jdk-12), the "Java Extention Pack" Extention, JUnit 5, and the Poweshell Extention installed.
        You can find your version of Java in your files
        JUnit 5 must be added to your settings.json file in VSCode in order to use testing.
            Download the JUnit jar file directly here: https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbEdtbWlnUEZDUngteUhZUTU0WHV6bmRhTFY3d3xBQ3Jtc0ttMC1yU3NhZEN5RzM1VkZmcUxMY0JlVi1JOWJ5UmJOYUdDOTlWNVJSQ1hPMEpoVlhyR202ZkVKZmhJU2V6WjZrbV9WZW5iRzgtd1BJZm53NTBpc1hzUDNGejdHYVVaRlMyMFBESmdramdfYTNDMFd6WQ&q=https%3A%2F%2Fsearch.maven.org%2Fremotecontent%3Ffilepath%3Dorg%2Fjunit%2Fplatform%2Fjunit-platform-console-standalone%2F1.6.0%2Fjunit-platform-console-standalone-1.6.0.jar 
                
                and put this code block in your settings.json file:

                "java.project.referencedLibraries": [
                "lib/**/*.jar",
                "Your file's address goes here!"
                ]

        The Java Extention Pack and Powershell Extention can both be installed directly in VSCode under the extentions tab
3. Open a PowerShell session
        Click the "Terminal" menu tab on the upper naviagion bar of VSCode.
        Open a PowerShell Integrated Console (click the dropdown on the console to chose this type of terminal window)
4. cd in the terminal into the path of the folder
5. type "./build.ps1" followed by your meal and your order in quotes and hit enter
        Ex. >>>./build.ps1 Lunch "1,2,3"

        This will run the powershell script to comple all files and run the test scripts as well as your input


HOW TO RUN INDIVIDUAL TESTS
1. You can also run your own tests manually outside of the shell script by, in the same terminal window by typing
        >>>java Meal (INSERT YOUR ORDER HERE)
        ex. >>>java Meal Lunch 1,2,3
                *note: don't put quotes around your order if you run individual tests, unlike when running the powershell buildscript


HOW TO RUN Test Files:
*note: your junit4.jar file path should be similar since it is included in the folder
1. In terminal window, if not already compiled from BuildScript, compile the test files with:
        >>>javac -cp "junit4.jar FILE PATH" TEST_FILE_NAME
        ex. >>>javac -cp "C:\Users\YOURNAME\OneDrive\Documents\Evive_engineering_test\junit4.jar;." DinnerTest.java
2. In the terminal window, once that test file is compiled, run the test with:
        >>>java -cp "junit4.jar FILE PATH" org.junit.runner.JUnitCore TEST_FILE_NAME
        ex. >>>java -cp "C:\Users\YOURNAME\OneDrive\Documents\Evive_engineering_test\junit4.jar;." org.junit.runner.JUnitCore DinnerTest