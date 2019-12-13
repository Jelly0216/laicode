package BfsDfs;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                }
                return c1.value < c2.value ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[row][col];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Cell curr = minHeap.poll();
            if (curr.row + 1 < row && !visited[curr.row + 1][curr.col]) {
                minHeap.offer(new Cell(curr.row + 1, curr.col, matrix[curr.row + 1][curr.col]));
                visited[curr.row + 1][curr.col] = true;
            }
            if (curr.col + 1 < col && !visited[curr.row][curr.col + 1]) {
                minHeap.offer(new Cell(curr.row, curr.col + 1, matrix[curr.row][curr.col + 1]));
                visited[curr.row][curr.col + 1] = true;
            }
        }
        return minHeap.peek().value;
    }
    static class Cell {
        int row;
        int col;
        int value;
        Cell (int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
