package classes.customer;

import java.util.Arrays;

public class MainCustomer {
    public static void main(String[] args) {
        Customer[] customers = new Customer[30];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(i);
        }

        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i]);
        }

        Arrays.sort(customers);
        System.out.println("\nОтсортированные");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i]);
        }
        System.out.println("\nВнутри интервала");
        int q = 1;
        for (int i = 0; i < customers.length; i++) {
            long start = 5555_1111_4123_9870L;
            long finish = 5555_4444_0000_0001L;
            if (customers[i].isNumberCardSizeInterval(start, finish)) {
                System.out.println(customers[i]);
                q++;
            }
        }
    }
}
