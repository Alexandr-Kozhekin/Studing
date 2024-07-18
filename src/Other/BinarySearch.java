package Other;

public class BinarySearch {

    public static void main(String[] args) {

        int size = 2555;

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i+1;
        }

        System.out.println("find number: " + array[search(63, array)]);

    }

    private static int search(int item, int[] array) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int guess = array[mid];

            if (guess == item) {
                return mid;
            }
            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return 0;
    }
}