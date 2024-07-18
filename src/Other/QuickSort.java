package Other;

public class QuickSort {

    public static void main(String[] args) {

        QuickSort quickSort = new QuickSort();

        int[] array = new int[]{2, 47, 13, 6, 3, 5, 7, 11, 9, 8};

        quickSort.quickSort(array, 0, array.length - 1);

        for(int q : array)
            System.out.println(q);

    }

    //low и high первый и последний элемент
    public void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pi = partition(arr, low, high);

            //вызываем для элементов массива меньше опорного
            quickSort(arr, low, pi - 1);
            //вызываем для элементов массива бльше опорного
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {

        //в качестве опорного элемента выбирается последний элемент массива
        int pivot = arr[high];

        // в дальнейгем определяет позицию опорного элемента после перестоновки
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //опорный элемент
        int temp = arr[i + 1];
        //на месо опорного элемента ставим последний элемент массива
        arr[i + 1] = arr[high];
        //опорный элемент ставится в конец массива
        arr[high] = temp;

        //возврошаем местоположение опорного элемента
        return i + 1;
    }
}