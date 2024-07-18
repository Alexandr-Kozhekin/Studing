package Other;

import java.util.Arrays;

class Recursion {

    public static void main(String[] args) {

        Recursion recursion = new Recursion();

//        int[] array = new int[]{21, 4, 2, 22, 4, 10, 14};

        int size = 50;
        int[] arrayForSearch = new int[size];

        for (int i = 0; i < arrayForSearch.length; i++) {
            arrayForSearch[i] = i+1;
        }

//        System.out.println(recursion.sumElementsArray(array));
//        System.out.println(recursion.elementCounting(array));
//        System.out.println(recursion.maxArrayElement(array));

        System.out.println("find number: " + recursion.search(50, arrayForSearch));

//        System.out.println(recursion.search(2, arrayForSearch));

    }

    public int sumElementsArray(int[] array) {
        if (array.length == 0) {
            return 0;
        } else {
            return array[array.length - 1] + sumElementsArray(Arrays.copyOf(array, array.length - 1));
        }
    }

    public int elementCounting(int[] array) {
        if (array.length == 0) {
            return 0;
        } else {
            return 1 + elementCounting(Arrays.copyOf(array, array.length - 1));
        }
    }

    public int maxArrayElement(int[] array) {
        if (array.length == 2) {
            return array[0] > array[1] ? array[0] : array[1];
        } else {
            int sub_max = maxArrayElement(Arrays.copyOf(array, array.length - 1));
            return array[array.length - 1] > sub_max ? array[array.length - 1] : sub_max;
        }
    }

    public int search(int item, int[] array) {

       if(array.length == 1) {
           return array[0] == item ? array[0] : 0;
       } else if (array[array.length / 2] > item) {
           return search(item, Arrays.copyOf(array,array.length / 2));
       } else {
           return search(item, Arrays.copyOfRange(array,array.length / 2, array.length));
       }
    }

}