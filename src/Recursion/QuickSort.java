public class Solution {
    public int[] quickSort(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right){
        if (left >= right) {
            return;
        }
        int privotPos = partition(array, left, right);
        quickSort(array, left, privotPos - 1);
        quickSort(array, privotPos + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int privotIndex = left + (int)(Math.random() * (right - left + 1));
        int privot = array[privotIndex];
        swap(array, privotIndex, right);
        int leftIndex = left;
        int rightIndex = right - 1;
        while(leftIndex <= rightIndex) {
            if (array[leftIndex] < privot) {
                leftIndex++;
            }
            else if (array[rightIndex] > privot) {
                rightIndex--;
            }
            else {
                swap(array, leftIndex++, rightIndex--);
            }
        }
        swap(array, leftIndex, right);
        return leftIndex;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
