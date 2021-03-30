package org.example;
import org.testng.TestNG;
import java.util.Arrays;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        TestNG testNG = new TestNG();
        List<String> file = Arrays.asList("src/main/java/resources/suite.xml");
        testNG.setTestSuites(file);
        testNG.run();
    }
}
