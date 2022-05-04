package leetcode;


public class Q0617_Merge_Two_Binary_Tree {;
    public static void main(String[] args) {
        //root1 = [1], root2 = [1,2]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1, new TreeNode(2),null);

        Solution s = new Solution();
        TreeNode ans = s.mergeTrees(node1, node2);
        ans.toString();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if(root1 == null )
                return root2;
            if(root2 == null)
                return root1;

            root1.val = root1.val + root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);

            return root1;
        }
    }
}
