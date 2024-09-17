/*
Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

Example 1:

Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
Example 2:

Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
 */
class StringsContainingBackspaces {

    public static boolean compare(String str1, String str2) {
        Stack<Character> stk1 = new Stack();
        Stack<Character> stk2 = new Stack();
        for (char c : str1.toCharArray()) {
            if (!stk1.isEmpty() && c == '#') stk1.pop();
            else if (c != '#') stk1.push(c);
        }
        for (char c : str2.toCharArray()) {
            if (!stk2.isEmpty() && c == '#') stk2.pop();
            else if (c != '#') stk2.push(c);
        }
        while (stk1.size() != stk2.size()) return false;
        while (!stk1.isEmpty() && !stk2.isEmpty()) {
            if (stk1.pop() != stk2.pop()) return false;
        }
        return true;
    }
}
