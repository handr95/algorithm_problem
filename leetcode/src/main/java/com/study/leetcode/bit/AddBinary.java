package com.study.leetcode.bit;

/**
 * 67. Add Binary
 * Easy
 * https://leetcode.com/problems/add-binary
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (aIdx >=  0 || bIdx >= 0) {
            int sum = carry;
            if (aIdx >= 0) {
                sum += a.charAt(aIdx) - '0';
                aIdx--;
            }
            if (bIdx >= 0) {
                sum += b.charAt(bIdx) - '0';
                bIdx--;
            }
            result.insert(0, sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            result.insert(0, carry);
        }

        return result.toString();
    }
}
