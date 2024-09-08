/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s= "hello"
Output: "holle"
Example 2:

Input: s= "AEIOU"
Output: "UOIEA"
 */
public class ReverseVowel {
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";
        int start = 0, end = s.length() - 1;
        char[] array = s.toCharArray();
        while (start < end) {
            while (start < end && vowel.indexOf(array[start]) == -1) start++;

            while (start < end && vowel.indexOf(array[end]) == -1) end--;

            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;

        }
        return new String(array);
    }
}
