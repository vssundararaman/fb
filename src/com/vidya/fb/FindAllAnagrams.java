package com.vidya.fb;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagrams {

    public static void main(String[] args) {
        String str = "cbaebabacd", p= "abc";

        System.out.println( findAllAngrams(str,p));
    }

    static List<Integer> findAllAngrams(String s, String p){
        List<Integer> result = new ArrayList<>();

        if(s == null || s.length() ==0 || s.length() < p.length()){
            return result;
        }

        int count = 0;

        int[] stringVal = new int[26];

        for(int i = 0; i< p.length() ; i++){
            count++;
            stringVal[p.charAt(i) - 'a']++;
        }

        int left = 0;
        for(int i = 0; i< s.length();i++){

            char c = s.charAt(i);
            stringVal[c - 'a']--;
            count--;

            if(count == 0){
                if(allZero(stringVal)){
                    result.add(left);
                }

                char lc = s.charAt(left);
                stringVal[lc - 'a']++;
                count++;
                left++;
            }
        }

        return result;
    }

    static boolean allZero(int[] map) {
        for (int i : map) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
