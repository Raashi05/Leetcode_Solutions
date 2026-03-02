/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
  */

//Brute Force
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int[] res = {-1,-1};
        while(start<nums.length){
            if(nums[start]==target){
                break;
            }
            start++;
        }
        if(start==nums.length){
            start = -1;
        }

        while(end>-1){
            if(nums[end] == target){
                break;
            }
            end--;
        }
        res[0] = start;
        res[1] = end;
        return res;
        
    }
}

//optimal approach with Binary Search
