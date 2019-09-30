package fundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class MainTaskTwo {
    public static void main(String[] args) {
        TaskTwo taskTwo = new TaskTwo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы");
        int n = scanner.nextInt();
        System.out.println("Введите диапазон");
        int range = scanner.nextInt();
        taskTwo.createSquareMatrix(n, range);
        taskTwo.printSquareMatrix();
        System.out.println("Сортировка по 3 столбцу");
        taskTwo.sortSquareMatrixOnColumn(3);
        taskTwo.printSquareMatrix();
        System.out.println("наибольшее число возрастающих элементов матрицы, идущих подряд");
        System.out.println(taskTwo.numberIncrementElements());
        taskTwo.printSquareMatrix();
        System.out.println("сумма элементов матрицы, расположенных между первым и вторым положительными " +
                "элементами каждой строки");
        System.out.println(Arrays.toString(taskTwo.sumBetweenFirstNegativeElementAndFirstPositiveElementInLine()));
        System.out.println("Матрица с удаленными сьолбцами и строками в которых находился максимальный элемент" );
        System.out.println(Arrays.deepToString(taskTwo.deleteLineAndColumnWitchMaxElement()));

    }
}
