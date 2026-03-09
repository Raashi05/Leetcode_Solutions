/*(This problem is an interactive problem.)
You may recall that an array arr is a mountain array if and only if:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

Example 1:
Input: mountainArr = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:
Input: mountainArr = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.

Constraints:
3 <= mountainArr.length() <= 104
0 <= target <= 109
0 <= mountainArr.get(index) <= 109
*/

//my code
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = peak_index(mountainArr);
        int target_index = binary_search(mountainArr,target,0,peak);
        if(target_index != -1){
            return target_index;
        }
        return binary_search(mountainArr,target,peak+1,mountainArr.length()-1);

        
    }

    static int peak_index(MountainArray mountainArr){
        int start = 0;
        int end = mountainArr.length() - 1;
        int mid = 0;
        while(start<end){
            mid = start + (end - start)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                start = mid+1;
            }else if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                end = mid;
            }
        }
        return start;
    }

    static int binary_search(MountainArray mountainArr,int target, int start, int end){
        Boolean asc = mountainArr.get(start)<mountainArr.get(end);
        
        int mid = 0;
        int mid_value = 0;
        while(start<=end){
            mid = start+(end-start)/2;
            mid_value = mountainArr.get(mid);
            if(mid_value == target){
                return mid;
            }
            if(asc){
                if(mid_value < target){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }else{
                if(mid_value < target){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}
