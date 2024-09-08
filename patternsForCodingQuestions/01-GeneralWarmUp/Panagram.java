import java.util.HashSet;

/*
A pangram is a sentence where every letter of the English alphabet appears at least once.
Given a string sentence containing English letters (lower or upper-case), return true if sentence is a pangram,
or false otherwise.

Note: The given sentence might contain other characters like digits or spaces, your solution should handle these too.

Example 1:
Input: sentence = "TheQuickBrownFoxJumpsOverTheLazyDog"
Output: true
Explanation: The sentence contains at least one occurrence of every letter of the English alphabet either in
lower or upper case.

Example 2:
Input: sentence = "This is not a pangram"
Output: false
Explanation: The sentence doesn't contain at least one occurrence of every letter of the English alphabet.
*/
class Panagram {

    public boolean checkIfPangram(String sentence) {
        // TODO: Write your code here
        HashSet<Character> set = new HashSet<>();
        for (char c : sentence.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) set.add(c);
        }
        return set.size() == 26;
    }

}
