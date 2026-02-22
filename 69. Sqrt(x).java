/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 
Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

Constraints:
0 <= x <= 231 - 1
  */

//my code
//using linear search
class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return x;
        }
        int sqrt = 1;
        while(sqrt <= x){
            if(sqrt == (x/sqrt)){
                return sqrt;
            }else if(sqrt > (x/sqrt)){
                break;
            }else{
                sqrt++;
            }
        }
        return sqrt-1;
    }
}

//using Binary Search
class Solution {
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        int start = 1;
        int end = x;
        int mid;
        int cal;
        while(start <= end){
            mid = (start+end)/2;
            cal = x/mid;
            if(mid == cal){
                return mid;
            }else if(mid < cal){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return end;
    }
}
