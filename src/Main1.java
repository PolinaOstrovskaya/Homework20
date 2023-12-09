public class Main1 {
    public static void main(String[] args) {
        int[] array = {5, 3, 7, 1, 9, 4, 2, 8, 6};
        System.out.println("Original array:");
        printArray(array);
        Task2 sorter1 = new Task2(array, "insertion");
        Task2 sorter2 = new Task2(array, "selection");
        Task2 sorter3 = new Task2(array, "bubble");
        try {
            Thread thread1 = new Thread(sorter1);
            Thread thread2 = new Thread(sorter2);
            Thread thread3 = new Thread(sorter3);
            thread1.start();
            thread2.start();
            thread3.start();
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sorted array by insertion sort:");
        printArray(sorter1.getSorted());
        System.out.println("Sorted array by selection sort:");
        printArray(sorter2.getSorted());
        System.out.println("Sorted array by bubble sort:");
        printArray(sorter3.getSorted());
    }

    public static void printArray(int[] array) {
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

