/*
There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.
For each location indices[i], do both of the following:
Increment all the cells on row ri.
Increment all the cells on column ci.
Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.

Example 1:
Input: m = 2, n = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
Example 2:
Input: m = 2, n = 2, indices = [[1,1],[0,0]]
Output: 0
Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.
 
Constraints:
1 <= m, n <= 50
1 <= indices.length <= 100
0 <= ri < m
0 <= ci < n
  */

// my code
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];

        int rows = indices.length;
        for(int i=0; i<rows; i++){
            int row = indices[i][0];
            int col = indices[i][1];
            update_matrix(matrix, row, col, m, n);
        }

        int res = check_odds(matrix, m, n);
        return res;
    }

    static void update_matrix(int[][] matrix,int row, int col, int m, int n){
        for(int i=0; i<n; i++){
            matrix[row][i] = matrix[row][i] + 1;
        }

        for(int i=0; i<m; i++){
            matrix[i][col] = matrix[i][col] + 1;
        }
    }

    static int check_odds(int[][] matrix,int m, int n){
        int r = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] % 2 != 0){
                    r++;
                }
            }
        }
        return r;
    }
}
