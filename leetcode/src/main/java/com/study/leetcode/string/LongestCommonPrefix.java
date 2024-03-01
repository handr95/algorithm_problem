package com.study.leetcode.string;

/**
 * 14. Longest Common Prefix
 * Easy
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 *
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        char[] bassChar = strs[0].toCharArray();
        int equalCnt = bassChar.length;
        for(int i = 1; i < strs.length; i ++) {
            char[] chars = strs[i].toCharArray();
            int index = 0;
            for (int j = 0; j < chars.length && j < bassChar.length; j ++) {
                if (bassChar[index] != chars[j]) {
                    break;
                }
                index++;
            }
            if (index < equalCnt) {
                equalCnt = index;
            }
        }

        return strs[0].substring(0, equalCnt);
    }

    public String solution2(String[] strs) {
        int n = strs.length;
        if(strs.length == 0){
            return"";
        }
        String prefix = strs[0];
        for(int i=1;i<n;i++){
            while(strs[i].indexOf(prefix) !=0){
                prefix = prefix.substring(0,prefix.length() - 1);
                if(prefix.isEmpty()){
                    return "";
                }
            }

        }

        return prefix;
    }
}
