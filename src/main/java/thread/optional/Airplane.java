package thread.optional;

import java.util.concurrent.TimeUnit;

public class Airplane extends Thread {
    String name;

    public Airplane(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Самалет " + name + " начал выходить на полосу");
            System.out.println("Полоса  приняла самолое " + name);
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Самалет " + name + " набирает скорость");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Самолет " + name + " взлетел");
            System.out.println("Полоса с самолетом " + name  + " освободилась");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
