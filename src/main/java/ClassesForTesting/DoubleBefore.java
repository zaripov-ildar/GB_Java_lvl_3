package ClassesForTesting;

import Annotations.BeforeSuite;
import Annotations.Test;

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
