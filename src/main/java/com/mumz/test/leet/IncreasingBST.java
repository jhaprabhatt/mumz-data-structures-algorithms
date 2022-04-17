package com.mumz.test.leet;

public class IncreasingBST {

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


    private static TreeNode inOrder(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode temp = root;
        root.left = null;
        root.right = null;
        if (left != null) {
            left = inOrder(left);
            temp = left;
            while (temp.right != null)
                temp = temp.right;
            temp.right = root;
        }

        if (right != null) {
            right = inOrder(right);
            while (temp.right != null)
                temp = temp.right;
            temp.right = right;
        }
        return left == null ? root : left;
    }

    public static void main(String[] args) {
        TreeNode root = inOrder(new TreeNode(6,
                                             null,
                                             new TreeNode(8,
                                                          new TreeNode(7),
                                                          new TreeNode(9)
                                             )
                                )
        );

        System.out.println(root);

        root = inOrder(new TreeNode(5,
                                    new TreeNode(3,
                                                 new TreeNode(2,
                                                              new TreeNode(1),
                                                              null
                                                 ), new TreeNode(4)
                                    ),
                                    new TreeNode(6,
                                                 null,
                                                 new TreeNode(8,
                                                              new TreeNode(7),
                                                              new TreeNode(9)
                                                 )
                                    )
                       )
        );

        System.out.println(root);
    }
}
