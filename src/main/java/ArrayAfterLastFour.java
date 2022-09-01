import java.util.Arrays;

public class ArrayAfterLastFour {
    public int[] getArray(int[] array) {
        int index = getLastFourIndex(array);
        int[] result = new int[array.length - index];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i + index];
        }
        return result;
    }

    private int getLastFourIndex(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                return i+1;
            }
        }
        throw new RuntimeException("The array " + Arrays.toString(array) +
                "\n contains no one 4");
    }
}
