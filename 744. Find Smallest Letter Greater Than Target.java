/*
You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters. 

Example 1:
Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
Example 2:
Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
Example 3:
Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].

Constraints:
2 <= letters.length <= 104
letters[i] is a lowercase English letter.
letters is sorted in non-decreasing order.
letters contains at least two different characters.
target is a lowercase English letter.
  */

//my code
//Brute force solution
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res = letters[0];
        for(int i=0; i<letters.length; i++){
            if(target<letters[i]){
                res = letters[i];
                break;
            }
        }
        return res;
    }
}

//if we look into pattern it is similar to finding a ciel of element.so here we can apply binary search to find the target solution.
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        int mid = 0;
        while(start <= end){
            mid = start +(end-start)/2;
            if(letters[mid]<=target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return letters[start%letters.length];
    }
}
