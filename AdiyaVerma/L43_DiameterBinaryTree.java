import java.util.Scanner;

public class L43_DiameterBinaryTree
{
	public static void main(String[] args)
	{
		System.out.println(diameterOfBinaryTree(root));
	}

	public int diameterOfBinaryTree(TreeNode root) {
        int result = Integer.MIN_VALUE;
        return diameter(root, result);
    }
    
    public int diameter(TreeNode node, int res)
    {
        if(node == null)
            return 0;
        int l = diameter(node.left, res);
        int r = diameter(node.right, res);
        
        int temp = 1 + Math.max(l,r);
        int ans = Math.max(temp, 1+l+r);
        res = Math.max(res, ans);
        
        return temp;
    }
}