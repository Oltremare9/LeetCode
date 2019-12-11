class Solution {
    public int longestUnivaluePath(TreeNode root) {

    }
    private int dfs(TreeNode node){
        int sum=0;
        if(node.left!=null && node.left.val==node.val)
            sum++;
        else if(node.right!=null && node.right.val==node.val)
            sum++;
        return sum+
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}