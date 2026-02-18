/*
Given an integer array nums, find the subarray with the largest sum, and return its sum. 

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 
Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
  */

//my code
//below code is brute force approch,but it will cause timecomplexity for given constraints.
class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        for(int i=0; i<nums.length-1; i++){
            int cur_sum = nums[i];
            for(int j=i+1; j<nums.length; j++){
                if(cur_sum > max_sum){
                    max_sum = cur_sum;
                }
                cur_sum = cur_sum+nums[j];
            }
            if(cur_sum > max_sum){
                    max_sum = cur_sum;
                }
        }
        if(nums[nums.length-1]>max_sum){
            max_sum = nums[nums.length-1];
        }
        return max_sum;
    }
}

//optimal solutions
class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int i = 1;
        int cur_sum = nums[0];
        while(i<nums.length){
            if(nums[i] > nums[i]+cur_sum){
                cur_sum = nums[i];
            }else{
                cur_sum = cur_sum + nums[i];
            }
            if(cur_sum > max_sum){
                max_sum = cur_sum;
            }
            i++;
        }
        return max_sum;        
    }
}
