package ClassesForTesting;

import Annotations.BeforeSuite;
import Annotations.Test;

public class WithoutAfter {
    @BeforeSuite
    public void beforeMethod(){
        System.out.println("This message is from beforeMethod");
    }
}
