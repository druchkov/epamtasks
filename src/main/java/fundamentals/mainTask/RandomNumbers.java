package fundamentals.mainTask;

import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество случайных чисел: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n ; i++) {
            System.out.println(new Random().nextInt());
        }
        for (int i = 0; i < n ; i++) {
            System.out.print(new Random().nextInt() + " ");
        }
    }
}
