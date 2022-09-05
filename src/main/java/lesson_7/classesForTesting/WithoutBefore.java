package lesson_7.classesForTesting;

import lesson_7.Annotations.AfterSuite;

public class WithoutBefore {
    @AfterSuite
    public void afterMethod(){
        System.out.println("This message is from afterMethod");
    }
}
