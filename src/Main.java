import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();

        Task1 maxSearcher = new Task1(array, true);
        Task1 minSearcher = new Task1(array, false);

        Thread maxThread = new Thread(maxSearcher);
        Thread minThread = new Thread(minSearcher);

        maxThread.start();
        minThread.start();

        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Максимальный элемент массива: " + maxSearcher.getResult());
        System.out.println("Минимальный элемент массива: " + minSearcher.getResult());
    }
}
