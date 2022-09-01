public class OnesAndFoursArray {

    public boolean containsOneAndFour(int[] array) {
        boolean containsOne = false;
        boolean containsFour = false;
        for (int j : array) {
            if (j == 1) {
                containsOne = true;
            } else if (j == 4) {
                containsFour = true;
            }
            if (containsFour && containsOne) {
                return true;
            }
        }
        return false;
    }
}
