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
class ComparingStringsContainingBackspaces {
    public static boolean compare(String str1, String str2) {
        int index1 = str1.length() - 1, index2 = str2.length() - 1;
        while (index1 >= 0 && index2 >= 0) {
            int i1 = getNextValidCharIndex(str1, index1);
            int i2 = getNextValidCharIndex(str2, index2);

            if (i1 < 0 && i2 < 0) return true;
            if (i1 < 0 || i2 < 0) return false;

            if (str1.charAt(i1) != str2.charAt(i2)) return false;

            index1 = i1 - 1;
            index2 = i2 - 1;
        }
        return true;
    }

    private static int getNextValidCharIndex(String str, int index) {
        int backspaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') backspaceCount++;
            else if (backspaceCount > 0) backspaceCount--;
            else break;
            index--;
        }
        return index;
    }
}
