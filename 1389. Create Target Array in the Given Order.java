/*
Given two arrays of integers nums and index. Your task is to create target array under the following rules:
Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.
It is guaranteed that the insertion operations will be valid.
Example 1:
Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
Example 2:
Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
Output: [0,1,2,3,4]
Explanation:
nums       index     target
1            0        [1]
2            1        [1,2]
3            2        [1,2,3]
4            3        [1,2,3,4]
0            0        [0,1,2,3,4]
Example 3:
Input: nums = [1], index = [0]
Output: [1]
 
Constraints:
1 <= nums.length, index.length <= 100
nums.length == index.length
0 <= nums[i] <= 100
0 <= index[i] <= i
  */

//my code
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int length = nums.length;
        int[] res = new int[length];
        for(int i=0; i<length; i++){
            if(i>index[i]){
                move_forward(res,index[i],length);
            }
            res[index[i]] = nums[i];
        }
        return res;
        
    }
    public static void move_forward(int[] res,int stop,int length){
        int j = length-2;
        while(j>=stop){
            res[j+1] = res[j];
            j--;
        }
    }
}
