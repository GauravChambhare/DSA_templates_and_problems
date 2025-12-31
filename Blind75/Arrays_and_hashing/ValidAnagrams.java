package Blind75.Arrays_and_hashing;
/*
 * https://neetcode.io/problems/is-anagram/question?list=neetcode150
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise 
 * return false.
 * An anagram is a string that contains the exact same characters as another string, but the order of 
 * the characters can be different.
*/

public class ValidAnagrams {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] freqs = new int[26];
        int[] freqt = new int[26];
        for(char c : s.toCharArray()) freqs[c-97] +=1;
        for(char c : t.toCharArray()) freqt[c-97] +=1;
        //we could have also usedd only 1 freq arry. in one strng we increment value and then in another lopp we decrement values from it for next string
        //again last time we go through the fre array and check if there is any non 0 value if there is will return false else true
        // return Arrays.equals(freqs, freqt);
        for(int i=0; i<26; i++){
            if(freqs[i]!=freqt[i]) return false;
        }
        return true;
    }
}
