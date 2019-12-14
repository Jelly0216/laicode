public class Solution {
    public int[] rainbowSort(int[] array) {
        // Write your solution here
        int left = 0;
        int mid = 0;
        int right = array.length - 1;
        while (mid <= right) {
            if (array[mid] == -1) {
                swap(array, left++, mid++);
            }
            else if(array[mid] == 0) {
                mid++;
            }
            else {
                swap(array, mid, right--);
            }
        }
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
