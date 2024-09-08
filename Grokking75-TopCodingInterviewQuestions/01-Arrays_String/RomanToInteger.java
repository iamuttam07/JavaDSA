import java.util.HashMap;
import java.util.Map;

/*
Given the Roman numeral string s, convert it into its equivalent integer and return it.

Roman numerals use combinations of seven symbols: I, V, X, L, C, D, and M, representing values 1, 5, 10, 50, 100, 500,
and 1000 respectively.

For example, II is equivalent to 1, and XI is equivalent to 11 (X + I). In some cases, a smaller numeral before a larger
numeral indicates subtraction (e.g., IV = 4).

Example 1:
Input: s = "XLII"
Output: 42
Justification: L (50) - X (10) + I (1) + I (1) = 42

Example 2:
Input: s = "CXCIV"
Output: 194
Justification: C (100) - X (10) + C (100) - I (1) + V (5) = 194
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));
            if (i < n - 1 && value < map.get(s.charAt(i + 1))) res -= value;
            else res += value;
        }
        return res;
    }
}
