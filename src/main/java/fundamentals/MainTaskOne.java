package fundamentals;

import java.util.Scanner;

public class MainTaskOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskOne taskOne = new TaskOne();
        System.out.println("Введите сколько чисел вы хотите ввести");
        String [] arrNumbers = new String[scanner.nextInt()];
        for (int i = 0; i < arrNumbers.length ; i++) {
            System.out.println("Введите число");
            arrNumbers[i] = scanner.next();
        }
        scanner.close();
        taskOne.minAndMaxLength(arrNumbers);
        taskOne.sortOfLength(arrNumbers);
        taskOne.lengthLessAverageLength(arrNumbers);
        taskOne.differentNumbersLeast(arrNumbers);
        taskOne.evenAndOdd(arrNumbers);
        taskOne.sortDigit(arrNumbers);
        taskOne.onlyDifferentNumbers(arrNumbers);
    }
}
