package lesson_7.classesForTesting;

import lesson_7.Annotations.BeforeSuite;

public class DoubleBefore {
    @BeforeSuite
    public void beforeMethod(){
        System.out.println("This message is from beforeMethod");
    }
    @BeforeSuite
    public void secondBeforeMethod(){
        System.out.println("This message is from beforeMethod");
    }

    
}
