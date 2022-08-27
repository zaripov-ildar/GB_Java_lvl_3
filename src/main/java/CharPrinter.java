import java.util.HashMap;
import java.util.Map;

public class CharPrinter {
    private static volatile char flag = 'C';
    private final Map<Character, Character> map = new HashMap<>();

    {
        map.put('A', 'B');
        map.put('B', 'C');
        map.put('C', 'A');
    }

    public synchronized void printChar(char c) {
        for (int i = 0; i < 5; i++) {
            while (!isMyTurn(c)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(c);
            setFlag(c);
            notifyAll();
        }
    }

    private void setFlag(char c) {
        flag = c;
    }

    private boolean isMyTurn(char sign) {
        return map.get(flag) == sign;
    }
}
