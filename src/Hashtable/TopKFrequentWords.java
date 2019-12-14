public class Solution {
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        if (combo.length == 0) {
            return new String[0];
        }
        Map<String, Integer> freqMap =  new HashMap<>();
        for (String s : combo) {
            Integer frequency = freqMap.get(s);
            if (frequency != null) {
                freqMap.put(s, frequency + 1);
            }
            else {
                freqMap.put(s, 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            }
            else if (minHeap.peek().getValue() < entry.getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        String[] res = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }
}
