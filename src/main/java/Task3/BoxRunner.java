package Task3;

public class BoxRunner {
    public static void main(String[] args) throws Exception {
        Box<Apple> box1 = new Box<>();
        box1.addFruit(new Apple(), new GoldenApple(), new Apple());
        System.out.println(box1.getWeight());

        Box<Orange> box2 = new Box<>();
        box2.addFruit(new Orange(), new Orange());
        System.out.println(box2.getWeight());

        System.out.println(box1.compare(box2));


        Box<Apple> box3 = new Box<>();
        System.out.println(box1);
        System.out.println(box3);

        box1.pourOutFruitsTo(box3);

        System.out.println(box1);
        System.out.println(box3);
    }
}
