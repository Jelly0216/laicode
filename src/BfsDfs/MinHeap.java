package BfsDfs;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {
    private int[] array;
    private int size;
    public MinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array can not be null or empty");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public MinHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity can be be equal or less than zero");
        }
        array = new int[cap];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) /2;
            if (array[parentIndex] > array[index]) {
                swap(array, parentIndex, index);
            }
            else {
                break;
            }
            index = parentIndex;
        }
    }

    private void percolateDown(int index) {
        while (index <= size / 2 - 1) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int swapCandidate = leftChildIndex;
            if (rightChildIndex < size && array[leftChildIndex] >= array[rightChildIndex]) {
                swapCandidate = rightChildIndex;
            }
            if (array[index] > array[swapCandidate]) {
                swap(array, index, swapCandidate);
            }
            else {
                break;
            }
            index = swapCandidate;
        }
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        return array[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        int res = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return res;
    }

    public void offer(int ele) {
        if (size == array.length) {
            //int[] newArray = new int[array.length * 2];
            //copy(array, newArray);
            int[] newArray = Arrays.copyOf(array, array.length * 2);
            array = newArray;
        }
        array[size] = ele;
        size++;
        percolateUp(size - 1);
    }

    public int update(int index, int ele) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("invalid index");
        }
        int res = array[index];
        array[index] = ele;
        if (res > ele) {
            percolateUp(index);
        }
        else {
            percolateDown(index);
        }
        return res;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
