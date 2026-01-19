package LeetcodeProblems;
/*
 * https://neetcode.io/problems/is-anagram/question?list=neetcode150
 * https://leetcode.com/problems/valid-anagram/description/?envType=problem-list-v2&envId=oizxjoit
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise 
 * return false.
 * An anagram is a string that contains the exact same characters as another string, but the order of 
 * the characters can be different.

    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:
    Input: s = "rat", t = "car"
    Output: false

    Constraints:
    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.
 */

import java.util.HashMap;
import java.util.Map;

public class ValidAnagrams {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] freqs = new int[26];
        int[] freqt = new int[26];
        for(char c : s.toCharArray()) freqs[c-97] +=1; //or freqs[c-'a'] either works
        for(char c : t.toCharArray()) freqt[c-97] +=1;
        //we could have also usedd only 1 freq arry. in one strng we increment value and then in another lopp we decrement values from it for next string
        //again last time we go through the fre array and check if there is any non 0 value if there is will return false else true
        // return Arrays.equals(freqs, freqt);
        for(int i=0; i<26; i++){
            if(freqs[i]!=freqt[i]) return false;
        }
        return true;
    }
    // Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
        /*
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0)+1);
        for(char r : t.toCharArray()){
            if(freq.get(r)==null || freq.get(r)==0) return false;
            freq.put(r, freq.get(r)-1);
        }
        for(char c : s.toCharArray()){
            if(freq.get(c)!=0) return false;
        }
        return true;
        */
}
