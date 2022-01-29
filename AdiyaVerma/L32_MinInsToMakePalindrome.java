import java.util.Scanner;


public class L32_MinInsToMakePalindrome
{
	public static void main(String[] args)
	{
		System.out.println(minInsertions("abecbda"));
	}




	//memoization
	  public static int minInsertions(String s) {
       StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String rev = sb.toString();
        int n = s.length();
        
        int[][] dp = new int[n+1][n+1];
        
        //intialise with -1
        for(int i = 0; i<=n; i++)
            for(int j = 0; j<=n; j++)
                dp[i][j] = -1;
                
        int lps = lps(s, rev, n, n, dp);
        
        
        //total length and the lps difference will give min no of insertion and deletions 
        return n-lps;
    }
    
    
    public static int lps(String x, String y, int m , int n, int[][] dp) 
    {
        if(m == 0 || n == 0)
            return 0;
        
        if(dp[m][n] != -1)
            return dp[m][n];
        
        if(x.charAt(m-1) == y.charAt(n-1))
            return dp[m][n] = 1 + lps(x, y, m-1, n-1, dp);
        
        return dp[m][n] = Math.max(lps(x, y, m, n-1, dp), lps(x, y, m-1, n, dp));
    }
}