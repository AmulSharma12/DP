import java.util.Scanner;

public class L31_SequencePatternMatching
{
	public static void main(String[] args)
	{
		String x = "AXY";
		String y = "ADXCPY";
		int m = x.length();
 		System.out.println(isSubsequence(x,y));

	}


	 //memoization -> leetcode 392
    public static boolean isSubsequence(String s, String t) {
        //s is a subsequence of t means we have to compare the length of s to length of lcs and if equal returns true;
        
        int m = s.length();
        int n = t.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 0; i<=m ; i++)
            for(int j = 0; j<=n; j++)
                dp[i][j] = -1;
                
                
        int lcs = lcs(s, t, m, n, dp);
        
        //if a length is equal to the length of lcs means all the character of string s is in lcs and also in string t
        if(lcs == m)
            return true;
        return false;
    }
    
    
    public static int lcs(String x, String y, int m, int n, int[][] dp)
    {
        if(m == 0 || n == 0)
            return 0;
        
        if(dp[m][n] != -1)      return dp[m][n];
        
        if(x.charAt(m-1) == y.charAt(n-1))
            return dp[m][n] = 1 + lcs(x, y, m-1, n-1, dp);
        
        return dp[m][n] = Math.max(lcs(x, y, m, n-1, dp) , lcs(x, y, m-1, n, dp));
    }
}