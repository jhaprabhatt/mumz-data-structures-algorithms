package com.mumz.test.dsa;

public class MaxDepthBinaryTree {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val,
                 TreeNode left,
                 TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxDepth(TreeNode root) {
        //If node is null
        if (root == null) return 0;
        //If both side of the node is null but not the node itself
        if (root.left == null && root.right == null) return 1;
        //Get the depth of left sub tree
        int left = 1 + maxDepth(root.left);
        //Get the depth of right sub tree
        int right = 1 + maxDepth(root.right);
        //return the max
        return Math.max(left, right);
    }

//    private static int maxDepth(TreeNode root,
//                                int count) {
//        if (root == null) return count;
//        if (root.left == null && root.right == null) return count + 1;
//        return maxDepth(root.left)
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                                     new TreeNode(9),
                                     new TreeNode(20,
                                                  new TreeNode(15),
                                                  new TreeNode(7)
                                     )
        );
        System.out.println(maxDepth(root));

        root = new TreeNode(1,
                            null,
                            new TreeNode(2)
        );
        System.out.println(maxDepth(root));
    }
}
