/*
Given an array of strings words and two different strings that already exist in the array word1 and word2, return
the shortest distance between these two words in the list.

Example 1:
Input: words = ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"], word1 = "fox", word2 = "dog"
Output: 5

Explanation: The distance between "fox" and "dog" is 5 words.
Example 2:

Input: words = ["a", "c", "d", "b", "a"], word1 = "a", word2 = "b"
Output: 1
Explanation: The shortest distance between "a" and "b" is 1 word. Please note that "a" appeared twice.
 */

class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int ans = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) index1 = i;
            else if (words[i].equals(word2)) index2 = i;
            if (index1 != -1 && index2 != -1) ans = Math.min(ans, Math.abs(index2 - index1));
        }
        return ans;
    }
}    
