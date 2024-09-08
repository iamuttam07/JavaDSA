/*
Given an integer array citations where citations[i] represents the number of times a researcher's ith paper has been
cited, return the researcher's h-index.
The h-index is defined as the maximum number h such that the researcher has h papers with at least h citations each.

Example 1
Input: citations = [4, 3, 0, 1, 5]
Expected Output: 3
Justification: The researcher has 3 papers with at least 3 citations each.

Example 2
Input: citations = [10, 8, 5, 4, 3, 7, 2, 1]
Expected Output: 4
Justification: The researcher has 4 papers with at least 4 citations each.

Example 3
Input: citations = [0, 1, 2, 3, 4]
Expected Output: 2
Justification: The researcher has 2 papers with at least 2 citations each.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int buckets[] = new int[n + 1];
        for (int c : citations) {
            if (c >= n) buckets[n]++;
            else buckets[c]++;
        }
        int count = 0;

        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) return i;
        }
        return 0;
    }
}
