package lesson_5;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private boolean theFirstOneCame;
    private final ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        this.theFirstOneCame = false;
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public synchronized void carFinished(String name) {
        if (theFirstOneCame) {
            return;
        }
        theFirstOneCame = true;
        System.out.println(name + " WIN!!!");
    }
}
