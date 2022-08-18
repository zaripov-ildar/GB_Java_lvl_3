import java.util.ArrayList;
import java.util.Collections;

public class Task2 {
    static <T> ArrayList<T> arrayToArrayList(T[] arr){
        ArrayList<T> result = new ArrayList<>();
        Collections.addAll(result, arr);
        return result;
    }
}
