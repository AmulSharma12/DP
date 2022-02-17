// maximum path sum from any node to any node

import java.util.Scanner;


class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

}


public class L49_MaximumPathSum
{
	public static void main(String[] args)
	{

		System.out.println(maxPathSum(root));
	}


	public static int maxPathSum(TreeNode root) {
        int result = Integer.MIN_VALUE;
        return pathSum(root, result);
    }
    
    
    public static int pathSum(TreeNode node , int res)
    {
        if(node == null)
            return 0;
        
        int l = pathSum(node.left, res);
        int r = pathSum(node.right , res);
        
        int tempAns = Math.max(node.val, Math.max(l+r+node.val, node.val));
        int ans = Math.max(tempAns , l+r+node.val);
        res = Math.max(res, ans);
        
        return tempAns;
    }
}