package ClassesForTesting;

import Annotations.AfterSuite;
import Annotations.Test;

public class WithoutBefore {
    @AfterSuite
    public void afterMethod(){
        System.out.println("This message is from afterMethod");
    }
}
