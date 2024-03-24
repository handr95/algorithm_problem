package com.study.leetcode.common;

import java.util.Objects;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }
        TreeNode[] nodes = new TreeNode[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                nodes[i] = new TreeNode(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (nodes[i] != null) {
                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;
                if (leftIndex < array.length) {
                    nodes[i].left = nodes[leftIndex];
                }
                if (rightIndex < array.length) {
                    nodes[i].right = nodes[rightIndex];
                }
            }
        }
        return nodes[0];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TreeNode other = (TreeNode) obj;
        return isEqual(this, other);
    }

    private boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val &&
                isEqual(node1.left, node2.left) &&
                isEqual(node1.right, node2.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}