import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {

    public static void main(String[] args) {
        Random random = new Random();
        int size = 10;
        SortingManager<Integer> sortingManager = new SortingManager<>();
        MaxHeap maxHeap = new MaxHeap();

        Integer[] items = new Integer[size];

        for (int i = 0; i < size; i++) {
            items[i] = random.nextInt(10000);
        }

        long start;
        start = System.nanoTime();
        Integer[] HeapSortedArr = maxHeap.heapSort(items);
        System.out.println("Time elapsed by Heap Sort: "+ (System.nanoTime() - start));

        start = System.nanoTime();
        Integer[] bubbleSortedArr = sortingManager.bubbleSort(items);
        System.out.println("\nTime elapsed by Bubble Sort: "+ (System.nanoTime() - start));

        start = System.nanoTime();
        Integer[] selectionSortedArr = sortingManager.selectionSort(items);
        System.out.println("\nTime elapsed by Selection Sort: "+ (System.nanoTime() - start));

        start = System.nanoTime();
        Integer[] insertionSortedArr = sortingManager.insertionSort(items);
        System.out.println("\nTime elapsed by Insertion Sort: "+ (System.nanoTime() - start));

        start = System.nanoTime();
        Integer[] mergeSortedArr = sortingManager.mergeSort(items);
        System.out.println("\nTime elapsed by Merge Sort: "+ (System.nanoTime() - start));

        start = System.nanoTime();
        Integer[] quickSortedArr = sortingManager.quickSort(items);
        System.out.println("\nTime elapsed by Quick Sort: "+ (System.nanoTime() - start));

    }
}
