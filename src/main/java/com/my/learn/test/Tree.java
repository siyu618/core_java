package com.my.learn.test;

/**
 * Created by yidianadmin on 14-11-14.
 */

 // Definition for binary tree

public class Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static {
        TreeNode[][] queue = new TreeNode[2][];
        queue[0] = new TreeNode[10000];
        queue[1] = new TreeNode[10000];
    }

    public static boolean isSymmetric(TreeNode root) {
        if (null == root || (root.left == null && root.right == null)) {
            return true;
        }
        TreeNode[][] queue = new TreeNode[2][];
        queue[0] = new TreeNode[10000];
        queue[1] = new TreeNode[10000];

        int size = 1;
        int index = 0;
        queue[index][0] = root;
        while (true) {
            for (int i=0, j= size-1; i<j; i++, j--) {
                if (null == queue[index][i] && null == queue[index][j]) {
                    continue;
                }
                else if (queue[index][i]!=null && queue[index][j]!=null) {
                    if (queue[index][i].val == queue[index][j].val) {
                        continue;
                    }else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }

            int index1 = 0;
            boolean allNull = true;
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue[index][i];
                if (node == null) {
                    queue[(index+1)%2][index1++] = null;
                    queue[(index+1)%2][index1++] = null;
                } else {
                    allNull = false;
                    queue[(index+1)%2][index1++] = node.left;
                    queue[(index+1)%2][index1++] = node.right;
                }
            }
            if (allNull) {break;}
            size *= 2;
            index = (index + 1)%2;
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(Tree.isSymmetric(root));
    }
}
