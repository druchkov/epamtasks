package fundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskTwo {
    private int[][] matrix;

    public int[][] createSquareMatrix(int size, int interval) { //0
        Random random = new Random();
        matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -interval + random.nextInt(2 * interval + 1);
            }
        }
        return matrix;
    }

    public void printSquareMatrix() {
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.printf("%4d", j);
            }
            System.out.println();
        }
    }

    public void sortSquareMatrixOnColumn(int k) {//1
        k = k - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][k] > matrix[j][k]) {
                    int t = matrix[i][k];
                    matrix[i][k] = matrix[j][k];
                    matrix[j][k] = t;
                }
            }
        }
    }

    public void sortSquareMatrixOnLine(int k) {//1
        k = k - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[k][i] > matrix[k][j]) {
                    int t = matrix[k][i];
                    matrix[k][i] = matrix[k][j];
                    matrix[k][j] = t;
                }
            }
        }
    }

    public int numberIncrementElements() { // 2,
        int maxInterval = 0;
        int currentInterval = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] < matrix[i][j + 1]) {
                    currentInterval++;
                }
                if (matrix[i][j] > matrix[i][j + 1]) {
                    if (maxInterval < currentInterval) {
                        maxInterval = currentInterval;
                    }
                    currentInterval = 0;
                }
            }
        }
        return maxInterval;
    }

    public int[] sumBetweenFirstNegativeElementAndFirstPositiveElementInLine() {// task3
        List<Integer> positiveJ = new ArrayList<>();
        List<Integer> negativeJ = new ArrayList<>();
        int[] sumInRow = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] > 0 && positiveJ.isEmpty()) {
                    positiveJ.add(column);
                }
                if (matrix[row][column] < 0 && negativeJ.isEmpty()) {
                    negativeJ.add(column);
                }
                if (!negativeJ.isEmpty() && !positiveJ.isEmpty()) {
                    int negative = negativeJ.get(0);
                    int positive = positiveJ.get(0);
                    int sum = 0;
                    if (negative > positive) {
                        int t = negative;
                        negative = positive;
                        positive = t;
                    }
                    for (int i = negative; i <= positive; i++) {
                        sum += matrix[row][i];
                    }
                    sumInRow[row] = sum;
                    negativeJ.clear();
                    positiveJ.clear();
                    break;
                }
                if (column == matrix[row].length - 1 && (negativeJ.isEmpty() || positiveJ.isEmpty())) {
                    System.out.println("В строке " + (row + 1) + " нет элементов с разными знаками. И сумма будет" +
                            " присвоена 9999");
                    sumInRow[row] = 9999;
                }
            }
            negativeJ.clear();
            positiveJ.clear();
        }
        return sumInRow;
    }

    public int[] sumBetweenFirstAndSecondPositiveElementsInLine() {
        int[] sumArr = new int[matrix.length];
        int startJ = 0;
        int finishJ = 0;
        int countPositive = 0;
        int column = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0 && countPositive == 0) {
                    startJ = j;
                    countPositive++;
                } else if (matrix[i][j] > 0 && countPositive == 1) {
                    finishJ = j;
                    countPositive++;
                    break;
                }
            }
            int sum = 0;
            if (countPositive == 2) {
                for (int j = startJ; j < finishJ + 1; j++) {
                    sum += matrix[i][j];
                }
            } else {
                System.out.println("В строке " + (i + 1) + " нет двуж положительных будет присвоенно 999" );
                sum = 999;
            }
            sumArr[column] = sum;
            column++;
            startJ = 0;
            finishJ = 0;
            countPositive = 0;
        }
        return sumArr;
    }

    private int maxElementSquareMatrix() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    public int[][] deleteLineAndColumnWitchMaxElement() {//4
        int max = maxElementSquareMatrix();
        List<Integer> rowIndex = new ArrayList<>();
        List<Integer> columnIndex = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == max) {
                    if (!rowIndex.contains(row)) {
                        rowIndex.add(row);
                    }
                    if (!columnIndex.contains(column)) {
                        columnIndex.add(column);
                    }
                }
            }
        }
        int[][] newMatrix = new int[matrix.length - rowIndex.size()][matrix.length - columnIndex.size()];
        int newMatrixRow = 0;
        int newMatrixColumn = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowIndex.contains(i)) {
                    newMatrixRow--;
                    break;
                }
                if (columnIndex.contains(j)) {
                    continue;
                }
                newMatrix[newMatrixRow][newMatrixColumn] = matrix[i][j];
                newMatrixColumn++;
            }
            newMatrixRow++;
            newMatrixColumn = 0;
        }
        return newMatrix;
    }
}

