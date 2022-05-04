import java.util.ArrayList;
import java.util.List;

public class SortingManager<T extends Comparable<T>> {

    public T[] bubbleSort(T[] unSortedArray){
        for(int i = 0; i < unSortedArray.length; i++){
            for(int j = 0; j < unSortedArray.length - 1 - i; j++){
                if(unSortedArray[j+1].compareTo(unSortedArray[j]) < 0){
                    T temp = unSortedArray[j];
                    unSortedArray[j] = unSortedArray[j + 1];
                    unSortedArray[j + 1] = temp;
                }
            }
        }
        return unSortedArray;
    }

    public T[] insertionSort(T[] unSortedArray){
        for(int i = 0; i < unSortedArray.length; i++){
            T temp = unSortedArray[i];
            int j = i-1;
            for(j = i-1; j >= 0 && unSortedArray[j].compareTo(temp) > 0; j--)
                unSortedArray[j+1] = unSortedArray[j];
            unSortedArray[j+1] = temp;
        }
        return unSortedArray;
    }

    public T[] selectionSort(T[] unSortedArray) {
        for (int i = 0; i < unSortedArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < unSortedArray.length; j++) {
                if (unSortedArray[j].compareTo(unSortedArray[min]) < 0)
                    min = j;
            }
            if(min != i){
                T temp = unSortedArray[i];
                unSortedArray[i] = unSortedArray[min];
                unSortedArray[min] = temp;
            }
        }
        return unSortedArray;
    }

    public T[] quickSort(T[] unSortedArray){
        return quickSort(unSortedArray,0, unSortedArray.length-1);
    }

    private T[] quickSort(T[] unSortedArray, int lower, int higher){
        if(lower < higher && lower > -1){
            int position = partition(unSortedArray, lower,higher);
            quickSort(unSortedArray,lower,position-1);
            quickSort(unSortedArray,position+1,higher);
        }
        return unSortedArray;
    }

    private int partition(T[] unSortedArray, int lower, int higher){
        T pivot = unSortedArray[lower];
        int start = lower, end = higher;
        while(start < end){
            while(unSortedArray[start].compareTo(pivot) <= 0)
                start++;
            while(unSortedArray[end].compareTo(pivot) > 0)
                end--;
            if(start < end){
                T temp = unSortedArray[start];
                unSortedArray[start] = unSortedArray[end];
                unSortedArray[end] = temp;
            }
        }
        unSortedArray[lower] = unSortedArray[end];
        unSortedArray[end] = pivot;
        return end;
    }

    public T[] mergeSort(T[] unSortedArray){
        return mergeSort(unSortedArray,0, unSortedArray.length - 1);
    }

    private T[] mergeSort(T[] unSortedArray, int lower, int higher){
        if(lower < higher){
            int mid = (lower + higher) / 2;
            mergeSort(unSortedArray,lower,mid);
            mergeSort(unSortedArray,mid+1,higher);
            unSortedArray = merge(unSortedArray,lower,mid,higher);
        }
        return unSortedArray;
    }

    private T[] merge(T[] unSortedArray, int lower, int mid, int higher){
        int i = lower, j = mid + 1;
        List<T> sortedSubArray = new ArrayList<T>();

        while(i <= mid && j <= higher){
            if(unSortedArray[i].compareTo(unSortedArray[j]) <= 0){
                sortedSubArray.add(unSortedArray[i]);
                i++;
            }
            else {
                sortedSubArray.add(unSortedArray[j]);
                j++;
            }
        }

        if(i > mid){
            while(j <= higher){
                sortedSubArray.add(unSortedArray[j]);
                j++;
            }
        }
        else{
            while(i <= mid){
                sortedSubArray.add(unSortedArray[i]);
                i++;
            }
        }
        int listIndex = 0;
        for(int k = lower; k <= higher; k++){
            unSortedArray[k] = sortedSubArray.get(listIndex);
            listIndex++;
        }
        return unSortedArray;
    }

}
