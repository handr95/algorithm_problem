package com.study.leetcode.dfs;

import com.study.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumDepthOfBinaryTreeTest {
    MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();

    @Test
    void test1() {
        TreeNode tree = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertThat(maximumDepthOfBinaryTree.maxDepth(tree)).isEqualTo(3);
    }

    @Test
    void test2() {
        TreeNode tree = TreeNode.createTree(new Integer[]{1,null,2});
        assertThat(maximumDepthOfBinaryTree.maxDepth(tree)).isEqualTo(2);
    }
}
