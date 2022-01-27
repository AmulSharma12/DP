import java.util.Scanner;

public class L26_LongestPalindromeSubsequence
{
	public static void main(String[] args)
	{
		String a = "bbbab";

		System.out.println(longestPalindromeSubseq(a));
	}


	 public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        String b = reverse(s);
        
        int[][] dp = new int[n+1][n+1];
        
        for(int i = 0; i<=n; i++)
        {
            for(int j = 0; j<=n; j++)
            {
               
                    dp[i][j] = -1;
            }
        }
        return lcs(s, b, n, n, dp);  
    }
    
    
    
    
    //lcs function to calculate the longestcommonsubsequence which is nothing but gives out the lps
    public static int lcs(String x, String y, int m, int n, int[][] dp)
    {
        if(m == 0 || n == 0)
            return 0;
        
        if(dp[m][n] != -1)  return dp[m][n];
        
        
        if(x.charAt(m-1) == y.charAt(n-1))
           return  dp[m][n] = 1 + lcs(x, y, m-1, n-1, dp);
    
        return dp[m][n] =  Math.max(lcs(x, y, m, n-1, dp) , lcs(x, y, m-1, n, dp));
    }
    
    
    
    //this function will reverse the string 
    public static String reverse(String a)
    {
        int n = a.length();
        StringBuilder sb = new StringBuilder(a);
        sb.reverse();
        
        return sb.toString();
    }
}