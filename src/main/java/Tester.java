import Annotations.AfterSuite;
import Annotations.BeforeSuite;
import Annotations.Test;
import ClassesForTesting.TestClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tester {

    public void start(Class testClass) {
        Method[] methods = testClass.getMethods();
        checkAfterAndBeforeAnnotations(methods);
        List<Method> methodList = getSortedMethodList(methods);
        TestClass test = new TestClass();
        for (Method method : methodList) {
            try {
                method.invoke(test);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Method> getSortedMethodList(Method[] methods) {
        List<Method> methodList = new ArrayList<>(List.of(methods));
        methodList = methodList.stream()
                .filter(m -> m.getAnnotation(AfterSuite.class) != null ||
                        m.getAnnotation(BeforeSuite.class) != null ||
                        m.getAnnotation(Test.class) != null)
                .collect(Collectors.toList());
        methodList.sort(new TestMethodsComparator());
        return methodList;
    }

    private void checkAfterAndBeforeAnnotations(Method[] methods) {
        int beforeAnnotations = 0,
                afterAnnotations = 0;
        for (Method method : methods) {
            if (method.getAnnotation(AfterSuite.class) != null) {
                afterAnnotations++;
            }
            if (method.getAnnotation(BeforeSuite.class) != null) {
                beforeAnnotations++;
            }
        }
        if (!(beforeAnnotations == 1 && afterAnnotations == 1)) {
            throw new RuntimeException("Every of annotations @AfterSuite and @BeforeSuite have to be represented only one time!\n" +
                    "\t@AfterSuite: " + afterAnnotations + ";\n" +
                    "\t@BeforeSuite: " + beforeAnnotations);
        }
    }
}
