import java.util.Arrays;

public class MaxHeap {
    int size;
    int maxSize;
    Integer[] elements;

    public MaxHeap() {
        size = 0;
        maxSize = 10;
        elements = new Integer[maxSize];
    }

    public Integer[] getElements() {
        return elements;
    }

    private void ensureExtraCapacity() {
        if(size == maxSize) {
            maxSize *= 2;
            elements = Arrays.copyOf(elements, maxSize);
        }
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int parent(int index) {
        return elements[getParentIndex(index)];
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int leftChild(int index) {
        return elements[getLeftChildIndex(index)];
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private int rightChild(int index) {
        return elements[getRightChildIndex(index)];
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private void swap(int index1, int index2) {
        int temp = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = temp;
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) < elements[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(int index) {
        while (hasLeftChild(index)) {
            int largestChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index))
                largestChildIndex = getRightChildIndex(index);
            if (elements[largestChildIndex] > elements[index]) {
                swap(index, largestChildIndex);
                index = largestChildIndex;
            }
            else
                break;
        }
    }

    public void insert(int element) {
        ensureExtraCapacity();
        elements[size] = element;
        size++;
        heapifyUp();
    }

    public int extract() {
        if (size == 0) throw new IllegalStateException();
        int element = elements[0];
        swap(0, size - 1);
        size--;
        heapifyDown(0);
        return element;
    }

    public void buildMaxHeap(Integer[] elements) {
        this.elements = elements;
        this.size = elements.length;
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    public Integer[] heapSort(Integer[] elements) {
        buildMaxHeap(elements);
        while (size != 0) {
            extract();
        }
        return elements;
    }

    public void displayHeap() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print("Parent Node -> "+ elements[i]);
            if(hasLeftChild(i)) {
                System.out.print(" Left Child Node -> " + leftChild(i));
                if (hasRightChild(i))
                    System.out.print(" Right Child Node -> "+ rightChild(i));
            }
            System.out.println();
        }
    }

}
