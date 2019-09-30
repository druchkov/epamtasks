package fundamentals.mainTask;

public class ReverseOrder {
    public static void main(String[] args) {
        for (int i = args.length - 1; i > -1; i--) {
            System.out.print(args[i] + " ");
        }
    }
}
