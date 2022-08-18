package Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruitBox;

    public Box() {
        this.fruitBox = new ArrayList<>();
    }

    @SafeVarargs
    public final <R extends T> void  addFruit(R... fruits) {
        Collections.addAll(fruitBox, fruits);
    }

    public float getWeight() {
        return (float) fruitBox.stream()
                .mapToDouble(Fruit::getWeight)
                .sum();
    }

    public boolean compare(Box<? extends Fruit> anotherBox) {
        return this.getWeight() == anotherBox.getWeight();
    }

    public  void pourOutFruitsTo(Box<? super T> anotherBox) throws Exception {
        if (anotherBox == null){
            throw new Exception("Box can't be null");
        }
        fruitBox.forEach(anotherBox::addFruit);
        fruitBox.clear();
    }

    @Override
    public String toString() {
        return "Box{" + "fruitBox=" + fruitBox +
                '}';
    }
}
