package fundamentals.mainTask;

public class SumComposition {
    public static void main(String[] args) {
        int sum = 0;
        int com = 1;
        for (int i = 0; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
            com *= Integer.parseInt(args[i]);
        }
        if (args.length > 0) {
            System.out.println("Сумма равна: " + sum + "\nПроизведение равно: " + com);
        }
    }
}
