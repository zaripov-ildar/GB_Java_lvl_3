public class Main {
    private static final CharPrinter printer = new CharPrinter();

    public static void main(String[] args) {
        createAndStart('A');
        createAndStart('B');
        createAndStart('C');
    }

    private static void createAndStart(char c) {
        (new Thread(() -> printer.printChar(c))).start();
    }
}
