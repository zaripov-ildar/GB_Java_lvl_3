import java.util.HashMap;
import java.util.Map;

public class CharPrinter {
    private static char flag;
    private final Map<Character, Character> map = new HashMap<>();
    private final String s;

    public CharPrinter(String s) {
        this.s = s;
        int lastIndex = s.length() - 1;
        this.setFlag(s.charAt(lastIndex));
        for (int i = 0; i < lastIndex; i++) {
            map.put(s.charAt(i), s.charAt(i + 1));
        }
        map.put(s.charAt(lastIndex), s.charAt(0));

    }

    private synchronized void printChar(char c, int repetitions) {
        for (int i = 0; i < repetitions; i++) {
            while (!isMyTurn(c)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(c);
            if (s.charAt(s.length()-1) == c){
                System.out.println();
            }
            setFlag(c);
            notifyAll();
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
            (new Thread(() -> printChar(value, repetitions))).start();
        }
    }
}
