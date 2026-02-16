/*
Given a square matrix mat, return the sum of the matrix diagonals.
Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

Example 1:
Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
Example 2:
Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8
Example 3:
Input: mat = [[5]]
Output: 5
  
Constraints:
n == mat.length == mat[i].length
1 <= n <= 100
1 <= mat[i][j] <= 100
  */

//my code
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;

        int left_diag_sum = cal_left_diag(mat, n);
        int right_diag_sum = cal_right_diag(mat, n);

        if(n%2 == 0){
            return left_diag_sum + right_diag_sum;
        }
        return left_diag_sum + right_diag_sum - mat[n/2][n/2];
    }

    static int cal_left_diag(int[][] mat, int n){
        int res = 0;
        for(int i=0; i<n; i++){
            res += mat[i][i];
        }
        return res;
    }

    static int cal_right_diag(int[][] mat, int n){
        int res = 0;
        int col = n-1;
        for(int i=0; i<n; i++){
            res += mat[i][col];
            col--;
        }
        return res;
    }
}
