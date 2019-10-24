class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            return dfs(root,L,R);
        }
        private int dfs(TreeNode root,int L,int R){
            if(root==null)
                return 0;
            else if(root.val<L)
                return dfs(root.right,L,R);
            else if(root.val>R)
                return dfs(root.left,L,R);
            else return dfs(root.right,L,R)+dfs(root.left,L,R)+root.val;
        }



    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}