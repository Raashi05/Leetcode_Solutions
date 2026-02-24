/*
You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
Given the integer n, return the number of complete rows of the staircase you will build.
  
Example 1:
Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.
Example 2:
Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.
 
Constraints:
1 <= n <= 231 - 1
  */

//my code
//liner search
class Solution {
    public int arrangeCoins(int n) {
        int line = 1;
        while(n>0){
            n = n-line;
            if(n == 0){
                return line;
            }else if(n < 0){
                line--;
                break;
            }else{
                line++;
            }
        }
        return line;
    }
}

//Binary Search
class Solution {
    public int arrangeCoins(int n) {
        long start = 1;
        long end = n;
        long mid = 0;
        long cal = 0;
        while(start<=end){
            mid = start + (end-start)/2;
            cal = mid*(mid+1)/2;
            if(cal==n){
                return (int)mid;
            }else if(cal>n){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return (int) end;
    }
}
