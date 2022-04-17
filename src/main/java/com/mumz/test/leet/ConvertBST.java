package com.mumz.test.leet;

public class ConvertBST {

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

        @Override
        public String toString() {
            return "TreeNode{" +
                   "val=" + val +
                   ", left=" + left +
                   ", right=" + right +
                   '}';
        }
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        if (root.right != null)
            convertBST(root.right);
        root.val = getBSTValue(root);
        if (root.left != null) {
            root.left.val += root.val;
            convertBST(root.left);
        }
        return root;
    }


    public static int getBSTValue(TreeNode root) {
        if (root == null) return 0;
        int val = 0;

        if (root.right != null && root.val < root.right.val)
            val += root.right.val;
        if (root.left != null && root.val < root.left.val)
            val += root.left.val;
        root.val += val;
        return Math.max(
                root.val,
                Math.max(root.right != null ? root.right.val : Integer.MIN_VALUE,
                         root.left != null ? root.left.val : Integer.MIN_VALUE
                )
        );
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                                     new TreeNode(1,
                                                  new TreeNode(0),
                                                  new TreeNode(2,
                                                               null,
                                                               new TreeNode(3)
                                                  )
                                     ),
                                     new TreeNode(6,
                                                  new TreeNode(5),
                                                  new TreeNode(7,
                                                               null,
                                                               new TreeNode(8)
                                                  )
                                     )
        );
        root = convertBST(root);
        System.out.println(root);
    }
}
