package Other;

public class SelectionSorted {

    public static void main(String[] args) {

        int[] array = new int[]{3,1,2,5,6,4,7,8,10,9};

        sorted(array);

        for (int j : array) {
            System.out.println(j);
        }

    }

    private static void sorted(int[] array) {

        for(int i = 0; i < array.length; i++) {

            int smallIndex = i;
            int smallElement = array[i];

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < smallElement) {
                    smallIndex = j;
                    smallElement = array[j];
                }
            }

            array[smallIndex] = array[i];
            array[i] = smallElement;

        }

    }


}