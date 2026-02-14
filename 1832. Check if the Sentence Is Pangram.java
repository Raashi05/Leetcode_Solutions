/*
A pangram is a sentence where every letter of the English alphabet appears at least once.
Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

Example 1:
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:
Input: sentence = "leetcode"
Output: false
 
Constraints:
1 <= sentence.length <= 1000
sentence consists of lowercase English letters.
*/


//my code

class Solution {
    public boolean checkIfPangram(String sentence) {
        int length = sentence.length();
        if(length<26){
            return false;
        }
        int ch_sum = cal_pangram(sentence,length);
        if(ch_sum==26){
            return true;
        }
        return false;
    }
    public static int cal_pangram(String sentence,int length){
         int[] res = new int[26];
        int index;
        for(int i=0; i<length; i++){
            index = sentence.charAt(i) - 97;
            if(res[index] != 1){
                res[index] = 1;
            }
        }
        int char_sum = 0;
        for(int i=0; i<26; i++){
            char_sum += res[i];
        }
        return char_sum;
    }
}
