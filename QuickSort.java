
import java.util.Arrays;
import java.util.Random;

public class QuickSortExample {

    // Quicksort method
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partitioning method (Lomuto scheme)
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choose last element as pivot
        int i = low - 1;  // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot into the correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Generate array with n unique random integers
    private static int[] generateRandomArray(int n, int maxRange) {
        Random rand = new Random();
        return rand.ints(1, maxRange)
                   .distinct()
                   .limit(n)
                   .toArray();
    }

    public static void main(String[] args) {
        // Part A
        int[] partA = {10, 80, 3, 19, 14, 7, 5, 12};
        System.out.println("Original (Part A): " + Arrays.toString(partA));
        quickSort(partA, 0, partA.length - 1);
        System.out.println("Sorted (Part A):   " + Arrays.toString(partA));

        // Part B: 100 unique random integers
        int[] partB = generateRandomArray(100, 1000);
        System.out.println("\nOriginal (Part B) first 10: " + Arrays.toString(Arrays.copyOf(partB, 10)));
        quickSort(partB, 0, partB.length - 1);
        System.out.println("Sorted (Part B) first 10:   " + Arrays.toString(Arrays.copyOf(partB, 10)));

        // Part C: 1000 unique random integers
        int[] partC = generateRandomArray(1000, 10000);
        System.out.println("\nOriginal (Part C) first 10: " + Arrays.toString(Arrays.copyOf(partC, 10)));
        quickSort(partC, 0, partC.length - 1);
        System.out.println("Sorted (Part C) first 10:   " + Arrays.toString(Arrays.copyOf(partC, 10)));
    }
}
