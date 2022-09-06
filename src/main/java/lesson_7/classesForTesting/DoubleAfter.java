package lesson_7.classesForTesting;


import lesson_7.Annotations.AfterSuite;

public class DoubleAfter {
    @AfterSuite
    public void afterMethod(){
        System.out.println("This message is from afterMethod");
    }
    @AfterSuite
    public void secondAfterMethod(){
        System.out.println("This message is from afterMethod");
    }
}
