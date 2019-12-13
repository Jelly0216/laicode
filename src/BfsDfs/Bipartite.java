package BfsDfs;

public class Solution {
    public boolean isBipartite(List<GraphNode> graph) {
        // write your solution here
        HashMap<GraphNode, Integer> visited = new HashMap<>();
        for (GraphNode node : graph) {
            if (!isBipartite(node, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBipartite(GraphNode node, HashMap<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> q = new LinkedList<>();
        q.offer(node);
        visited.put(node, 0);
        while (!q.isEmpty()) {
            GraphNode currNode = q.poll();
            int currColor = visited.get(currNode);
            int neiColor = currColor == 0 ? 1 : 0;
            for (GraphNode neiNode : currNode.neighbors) {
                if (!visited.containsKey(neiNode)) {
                    visited.put(neiNode, neiColor);
                    q.offer(neiNode);
                }
                else if (visited.get(neiNode) != neiColor) {
                    return false;
                }
            }
        }
        return true;
    }
}
