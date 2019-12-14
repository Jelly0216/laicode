package BinarySearch;

public class Solution {
    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        if(array == null || array.length == 0) return array;
        if(k == 0) return new int[0];
        int left = 0, right = array.length - 1;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(array[mid] <= target) left = mid;
            else if(array[mid] > target) right = mid;
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            if(right >= array.length || left >= 0 && target - array[left] < array[right] - target){
                result[i] = array[left--];
            }
            else{
                result[i] = array[right++];
            }
        }
        return result;
    }
}