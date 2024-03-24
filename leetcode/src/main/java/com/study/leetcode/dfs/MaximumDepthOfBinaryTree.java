package com.study.leetcode.dfs;


import com.study.leetcode.common.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * Easy
 * https://leetcode.com/problems/maximum-depth-of-binary-trees
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *     3
 *   /  \
 *  9   20
 *     / \
 *    15  7
 *
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaximumDepthOfBinaryTree {
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        int depth = 1;
        maxDepthWhile(root, depth);
        return maxDepth;
    }

    public void maxDepthWhile(TreeNode node, int depth) {
        if(node == null) {
            return;
        }
        if(node.left != null) {
            maxDepthWhile(node.left, depth + 1);

        }
        if(node.right != null)  {
            maxDepthWhile(node.right, depth + 1);
        }
        if (depth > maxDepth) {
            maxDepth = depth;
        }
    }

    public int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(solution1(root.left), solution1(root.right)) + 1;
    }
}
