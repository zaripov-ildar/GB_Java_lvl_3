public class Main {

    public static void main(String[] args) {
        CharPrinter printer = new CharPrinter("ABC");
        printer.startThreadForEachChar(5);
    }
}
