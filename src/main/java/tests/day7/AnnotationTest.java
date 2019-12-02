package tests.day7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnotationTest {

    public void setup(){
        //some code that will be running before every test, like: test1, test2, test3....
        //we can use method with @BeforeMethod annotation
    }

    @Test
    public void test1(){
        System.out.println("Test 1!");
        Assert.assertTrue(5==5);
    }
    @Test
    public void test2(){
        System.out.println("Test 2!");

    }
    @Test
    public void test3(){
        System.out.println("Test 3!");
    }
}
