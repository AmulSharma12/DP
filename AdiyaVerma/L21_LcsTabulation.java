import java.util.Scanner;


public class L21_LcsTabulation
{
	public static void main(String[] args)
	{
		String a = "abcde";
		String b = "ace";

		int result  =  longestCommonSubsequence(a, b);
		System.out.println(result);

	}

	 public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        
        //initialisation
        for(int i = 0; i<=m; i++)
            for(int j = 0; j<=n; j++)
                dp[i][j] = 0;
        
        
        //logic
        for(int i = 1; i<=m ;i++)
            for(int j = 1; j<=n; j++)
            {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                
                else
                    dp[i][j] = max(dp[i-1][j] , dp[i][j-1]);
            }
        
        
        return dp[m][n];
    }
    
    
    
    public static int max(int first , int second)
    {
        return first > second ? first : second;
    }
}