package lesson_5;

import java.util.Arrays;
import java.util.concurrent.*;

public class Main {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT + 1);
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cdl, barrier);
        }
        ExecutorService service = Executors.newCachedThreadPool();

        Arrays.stream(cars).forEach(service::submit);

        waitForPreparation(cdl);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        waitForRaceEnding(barrier);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        service.shutdownNow();
    }

    private static void waitForRaceEnding(CyclicBarrier barrier) {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static void waitForPreparation(CountDownLatch cdl) {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

