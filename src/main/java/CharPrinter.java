import java.util.HashMap;
import java.util.Map;

public class CharPrinter {
    private static char flag;
    private final Map<Character, Character> map = new HashMap<>();
    private final String s;

    public CharPrinter(String s) {
        this.s = s;
        this.setFlag(s.charAt(s.length() - 1));
        initiateMap();

    }

    private void initiateMap() {
        for (int i = 0; i < s.length() - 1; i++) {
            map.put(s.charAt(i), s.charAt(i + 1));
        }
        map.put(s.charAt(s.length() - 1), s.charAt(0));
    }


    private synchronized void checkTurnAndPrint(char c) {
        checkTurn(c);
        printChar(c);
        setFlag(c);
        notifyAll();
    }

    private void checkTurn(char c){
        while (!isMyTurn(c)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printChar(char c){
        System.out.print(c);
        if (s.charAt(s.length() - 1) == c) {
            System.out.print(" ");
        }

    }


    private void setFlag(char c) {
        flag = c;
    }

    private boolean isMyTurn(char c) {
        return map.get(flag) == c;
    }

    public void startThreadForEachChar(int repetitions) {
        for (Character value : map.values()) {
            for (int i = 0; i < repetitions; i++) {
                (new Thread(() -> checkTurnAndPrint(value))).start();
            }
        }
    }
}
