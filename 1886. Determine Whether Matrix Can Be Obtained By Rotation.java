/*
Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

Example 1:
Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
Example 2:
Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
Output: false
Explanation: It is impossible to make mat equal to target by rotating mat.
Example 3:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
 
Constraints:
n == mat.length == target.length
n == mat[i].length == target[i].length
1 <= n <= 10
mat[i][j] and target[i][j] are either 0 or 1.
  */

//my code
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        if(check(mat, target)){
            return true;
        }
        for(int i=0; i<3; i++){
            rotate(mat);
            if(check(mat,target)){
                return true;
            }
        }
        return false;
    }

    static Boolean check(int[][] mat, int[][] target){
        for(int row=0; row<mat.length; row++){
            for(int col=0; col<mat[row].length; col++){
                if(mat[row][col] != target[row][col]){
                    return false;
                }
            }
        }
        return true;
    }

    static void rotate(int[][] mat){
        int[][] temp = new int[mat.length][mat[0].length];

        for(int row=0; row<mat.length; row++){
            for(int col=0; col<mat[row].length; col++){
                temp[row][col] = mat[row][col];
            }
        }

        for(int row=0; row<mat.length; row++){
            int cur_col = mat[row].length - 1;
            for(int col=0; col<mat[row].length; col++){
                mat[row][col] = temp[cur_col][row];
                cur_col--;
            }
        }
    }
}
