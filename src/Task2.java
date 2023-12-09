import java.util.Arrays;

public class Task2 implements Runnable {
    private int[] array;
    private int[] sorted;
    private String type;


    public Task2(int[] array, String type) {
        this.array = array;
        this.type = type;
    }

    @Override
    public void run() {
        sorted = Arrays.copyOf(array, array.length);

        switch (type) {
            case "insertion":
                insertionSort(sorted);
                break;
            case "selection":
                selectionSort(sorted);
                break;
            case "bubble":
                bubbleSort(sorted);
                break;
            default:
                System.out.println("Unknown type of sorting: " + type);
                break;
        }
    }

    private void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }


    private void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    private void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public int[] getSorted() {
        return sorted;
    }
}

