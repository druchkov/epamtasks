package thread.optional;

public class Main {
    public static void main(String[] args) {
        Airplane[] airplanes = new Airplane[10];
        for (int i = 0; i < 10; i++) {
            airplanes[i] = new Airplane("№100" + Integer.toString(i + 1));
        }
        int i = 0;
        while (true) {
            if (Thread.activeCount() <= 6) {
                airplanes[i].start();
                i++;
                if (i > 9) {
                    break;
                }
            }
        }
    }
}
