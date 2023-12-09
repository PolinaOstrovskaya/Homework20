public class Task1 implements Runnable {
    private int[] array;
    private int result;
    private boolean isMax;

    public Task1(int[] array, boolean isMax) {
        this.array = array;
        this.isMax = isMax;
    }

    public void run() {

        result = array[0];

        for (int i = 1; i < array.length; i++) {

            if (isMax && array[i] > result) {
                result = array[i];
            }

            if (!isMax && array[i] < result) {
                result = array[i];
            }
        }
    }

    public int getResult() {
        return result;
    }
}

