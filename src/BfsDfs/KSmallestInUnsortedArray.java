package BfsDfs;

public class Solution {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        if (array.length == 0 || k==0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer l1, Integer l2) {
                if (l1.equals(l2)) {
                    return 0;
                }
                return l1 > l2? -1 : 1;
            }
        });
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            }
            else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i-- ){
            res[i] = maxHeap.poll();
        }
        return res;
    }
}
