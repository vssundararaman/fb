package com.vidya.fb;

/**
 * 680. Valid Palindrome II
 * <p>
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(isValidPalidrome(s));

        s = "abca";
        System.out.println(isValidPalidrome(s));
    }

    static boolean isValidPalidrome(String string) {
        int i = 0, j = string.length() - 1;

        while (i < j) {
            if (string.charAt(i) != string.charAt(j)) {
                return isPalindrome(string, i + 1, j) || isPalindrome(string, i, j - 1);
            }
            //Increment the i and decrement the j
            i++;
            j--;
        }
        return true;
    }

    static boolean isPalindrome(String string, int i, int j) {
        while (i < j) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
