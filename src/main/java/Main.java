import java.io.File;

public class Main {
    private static final Tester tester = new Tester();
    public static void main(String[] args) throws ClassNotFoundException {
        Class[] classes = getTestedClassList();


        for (Class testedClass : classes) {
            System.out.println(testedClass.getSimpleName() + ".class is being tested");

            runTest(testedClass);

            System.out.println("\n-------------------\n");
        }
    }

    private static void runTest(Class testedClass) {
        try {
            tester.start(testedClass);
        } catch (Exception e) {
            System.out.println(testedClass.getSimpleName() + " threw an exception:\n\t" + e.getMessage());
        }
    }

    private static Class[] getTestedClassList() {
        File dir = new File("src/main/java/ClassesForTesting");
        File[] arrFiles = dir.listFiles();
        if (arrFiles == null) {
            throw new RuntimeException("Couldn't find files");
        }
        Class[] classes = new Class[arrFiles.length];

        for (int i = 0; i < arrFiles.length; i++) {
            String className = "ClassesForTesting." + (arrFiles[i].getName()).split("\\.")[0];
            try {
                classes[i] = Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return classes;
    }
}
