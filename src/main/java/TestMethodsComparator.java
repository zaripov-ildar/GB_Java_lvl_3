import Annotations.AfterSuite;
import Annotations.BeforeSuite;
import Annotations.Test;

import java.lang.reflect.Method;
import java.util.Comparator;

public class TestMethodsComparator implements Comparator<Method> {

    @Override
    public int compare(Method o1, Method o2) {
        int a = getMethodPriority(o1);
        int b = getMethodPriority(o2);
        return a - b;
    }

    private int getMethodPriority(Method method) {
        int AFTER_SUITE_PRIORITY = 0;
        int BEFORE_SUITE_PRIORITY = 11;
        if (method.getAnnotation(AfterSuite.class) != null) {
            return AFTER_SUITE_PRIORITY;
        } else if (method.getAnnotation(BeforeSuite.class) != null) {
            return BEFORE_SUITE_PRIORITY;
        }
        return method.getAnnotation(Test.class).priority();
    }
}
