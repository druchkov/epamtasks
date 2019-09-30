package fundamentals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskOne {

    public String[] inputData() {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextLine());
        }
        return (String []) list.toArray();
    }

    public void minAndMaxLength(String[] number) { //1*
        int max = 0;
        int min = 0;
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        for (String x : number) {
            if (x.length() > maxLength) {
                max = Integer.parseInt(x);
                maxLength = x.length();
            }
            if (x.length() < minLength) {
                min = Integer.parseInt(x);
                minLength = x.length();
            }
        }
        System.out.println("длинное число " + max + " его длина " + maxLength +
                "\nкороткое число " + min + " его длина " + minLength);
    }

    public void sortOfLength(String[] number) { // 2*
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length - 1 - i; j++) {
                if (number[j].length() > number[j + 1].length()) {
                    String t = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = t;
                }
            }
        }
        System.out.println(Arrays.toString(number));
    }

    public void lengthLessAverageLength(String[] number) { //3*
        double sumLength = 0;
        for (String x : number) {
            sumLength += x.length();
        }
        double mid = sumLength / number.length;
        for (String x : number) {
            if (x.length() < mid) {
                System.out.println(x + " " + x.length());
            }
        }
    }

    public void differentNumbersLeast(String[] number) {//4
        String[] differentN = new String[number.length];
        int minDiffCount = Integer.MAX_VALUE;
        String rightNumber = "";
        for (int k = 0; k < number.length; k++) {
            String t = number[k];
            for (int i = 0; i < t.length() - 1; i++) {
                for (int j = i + 1; j < t.length(); j++) {
                    if (t.charAt(i) == t.charAt(j)) {
                        t = t.replaceAll("" + t.charAt(i), "");
                        i = 0;
                    }
                }
            }
            differentN[k] = t;

        }
        for (int i = 0; i < differentN.length; i++) {
            if (differentN[i].length() < minDiffCount) {
                minDiffCount = differentN[i].length();
                rightNumber = number[i];
            }
        }
        System.out.println(rightNumber);
    }

    public void evenAndOdd(String[] number) {// 5*
        ArrayList<Integer> onlyEven = new ArrayList<>();
        ArrayList<Integer> onlyOdd = new ArrayList<>();
        int countOddEqualsEven = 0;
        for (String x : number) {
            int n = Integer.parseInt(x);
            while (n > 0) {
                if ((n % 10) % 2 != 0) {
                    onlyOdd.add(Integer.parseInt(x));
                    break;
                }
                n = (n - (n % 10)) / 10;
            }
        }
        for (int i = 0; i < number.length; i++) {
            boolean flag = false;
            int j = 0;
            while (j < onlyOdd.size()) {
                if (Integer.parseInt(number[i]) == onlyOdd.get(j)) {
                    flag = true;
                    break;
                }
                j++;
            }
            if (!flag) {
                onlyEven.add(Integer.parseInt(number[i]));
            }
        }

        for (String x : number) {
        }
        while (onlyOdd.size() > 0) {
            int n = onlyOdd.get(0);
            int q = n;
            int countOdd = 0;
            int countEven = 0;
            while (n > 0) {
                if ((n % 10) % 2 == 1) {
                    countOdd++;
                    n = (n - (n % 10)) / 10;
                    continue;
                }
                if ((n % 10 != 0) && (n % 10) % 2 == 0) {
                    countEven++;
                    n = (n - (n % 10)) / 10;
                    continue;
                }
                n = (n - (n % 10)) / 10;
            }
            onlyOdd.remove(0);
            if (countEven == countOdd) {
                countOddEqualsEven++;
            }
        }
        System.out.println("Количество чисел содержащих только четные цифры = " + onlyEven.size() +
                "\nКоличество чисел с равным числом четных и нечетных цифр = " + countOddEqualsEven);
    }

    public void sortDigit(String[] number) { //6*
        int i = 0;
        while (i < number.length) {
            if (number[i].length() < 2) {
                i++;
                continue;
            }
            int[] arr = new int[number[i].length()];
            int[] arrForSort = new int[number[i].length()];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = number[i].charAt(j);
                arrForSort[j] = number[i].charAt(j);
            }
            Arrays.sort(arrForSort);
            if (Arrays.equals(arr, arrForSort)) {
                System.out.println("Число отсортированно" + number[i]);
                break;
            }
            i++;
        }
    }

    public void onlyDifferentNumbers(String[] number) { //7*
        int i = 0;
        int finish = number.length;
        while (i < finish) {
            if (isDifferent(number[i])) {
                System.out.println(number[i]);
                break;
            }
            i++;
        }
    }

    private boolean isDifferent(String number) { // метод для нахождения числа составленного из различных чисел
        if (number.length() < 2) {
            return false;
        }
        for (int i = 0; i < number.length() - 1; i++) {
            for (int j = i + 1; j < number.length(); j++) {
                if (number.charAt(i) == number.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}