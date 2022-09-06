package lesson_7.classesForTesting;

import lesson_7.Annotations.BeforeSuite;

public class WithoutAfter {
    @BeforeSuite
    public void beforeMethod(){
        System.out.println("This message is from beforeMethod");
    }
}
