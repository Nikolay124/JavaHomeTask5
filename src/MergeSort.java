import java.util.Arrays;

public class MergeSort {
    private static final int[] EMPTY_ARRAY = {};

    public static void main(String[] args) {
        int[] array = {5, 6, 2, 4, 8, 1, 3};
        int[] sortedArray = mergeSort(array);
        System.out.println("Initial array: " + Arrays.toString(array));
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }
    private static int[] merge(int[] a1, int[] a2) {
        int[] mergedArray = new int[a1.length + a2.length];
        int i1 = 0, i2 = 0, index = 0;
        while (i1 < a1.length && i2 < a2.length) {
            if (a1[i1] < a2[i2]) {
                mergedArray[index++] = a1[i1++];
            } else {
                mergedArray[index++] = a2[i2++];
            }
        }

        while (i1 < a1.length) {
            mergedArray[index++] = a1[i1++];
        }

        while (i2 < a2.length) {
            mergedArray[index++] = a2[i2++];
        }
        return mergedArray;
    }


    private static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int middle = array.length / 2;
        int[] leftHalf = Arrays.copyOfRange(array, 0, middle);
        int[] rightHalf = Arrays.copyOfRange(array, middle, array.length);
        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);
        return merge(leftHalf, rightHalf);
    }
}