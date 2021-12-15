package c5.sort;

public class QuickSort {
    public static void quickSort(int [] arr, int l, int r) {
        if (l == r) return;
        int pivot = partition(arr, l, r);
        quickSort(arr, l, pivot);
        quickSort(arr, pivot + 1, r);
    }

    //partition
    static int partition(int[] arr, int l, int r) {
        return 0;
    }
}
