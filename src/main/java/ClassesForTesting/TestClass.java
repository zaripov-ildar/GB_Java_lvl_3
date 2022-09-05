package ClassesForTesting;

import Annotations.*;

public class TestClass {
    @BeforeSuite
    public void beforeMethod(){
        System.out.println("This message is from beforeMethod");
    }

    @Test(priority = 1)
    public void testMethod1(){
        System.out.println("Working method with priority #1");

    }

    @Test(priority = 3)
    public void testMethod2(){
        System.out.println("Working method with priority #3");
    }

    @Test(priority = 3)
    public void testMethod3(){
        System.out.println("Working method with priority #3");
    }

    @Test(priority = 5)
    public void testMethod4(){
        System.out.println("Working method with priority #5");
    }

    @AfterSuite
    public void afterMethod(){
        System.out.println("This message is from afterMethod");
    }
}
